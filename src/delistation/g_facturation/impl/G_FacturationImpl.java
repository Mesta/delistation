package delistation.g_facturation.impl;

import java.util.logging.Level;

import delistation.datatypes.CompteMode;
import delistation.datatypes.Zone;
import delistation.exceptions.ExceptionErreurPaiement;
import delistation.g_facturation.G_FacturationPOA;
import delistation.utils.Topographie;

public class G_FacturationImpl extends G_FacturationPOA {

	public final static short montant_inscription = 50;
	public final static short montant_base_transport = 20;

	private Topographie topographie;
	private G_FacturationDBHelper dbHelper;
	
	/**
	 * Constructeur par défaut.
	 */
	public G_FacturationImpl() {
		this.topographie = new Topographie();
		this.dbHelper = new G_FacturationDBHelper();
	}

	public boolean creerCompte(short noAdh, CompteMode createMode) {
		return this.dbHelper.creerCompte(noAdh, createMode);
	}

	/**
	 * Méthode de facturation d'une adhésion.
	 * 
	 * @param RIB Informations bancaires du compte nécessaire.
	 * @throws ExceptionErreurPaiement Si une erreur de paiement survient.
	 * @return Montant de la facture d'adhésion.
	 */
	public short factureAdhesion(String RIB) throws ExceptionErreurPaiement {
		G_FacturationServeur.lgr.log(Level.INFO, "Facturation de " + RIB);
		if (this.dbHelper.debiter(RIB, G_FacturationImpl.montant_inscription))
			return montant_inscription;
		else
			throw new ExceptionErreurPaiement("Une erreur inconnue est survenue durant le réglement de votre adhésion. Veuillez recommencer plus tard.");
	}
	
	/**
	 * Calcule le prix d'un transport d'une {@link Zone} de départ à une {@link Zone} d'arrivée.
	 * 
	 * @param zoneDep Zone de départ du colis.
	 * @param zoneDest Zone d'arrivée du colis.
	 * @return Montant du transport.
	 */
	public short devisTransport(Zone zoneDep, Zone zoneDest) {
		if (zoneDep.commune == zoneDest.commune)
			return montant_base_transport / 2;

		else {
			if (this.topographie.is_mitoyen(zoneDep, zoneDest))
				return montant_base_transport;
			else
				return montant_base_transport * 2;
		}
	}
	
	/**
	 * Opération de débit d'un adhérent.
	 * 
	 * @param RIB Informations bancaire de l'adhérent à débiter.
	 * @param montant Montant à débiter.
	 * @throws ExceptionErreurPaiement Si une erreur survient durant le paiement.
	 * @return Booléen de confirmation de l'opération de débit.
	 */
	public boolean debiterAdherent(String RIB, short montant)
			throws ExceptionErreurPaiement {
		if (this.dbHelper.getSolde(RIB) >= montant) {
			if (this.dbHelper.debiter(RIB, montant))
				return true;
			else
				throw new ExceptionErreurPaiement("Une erreur inconnue est survenue durant le paiement. Veuillez recommencer plus tard.");
		} else {
			throw new ExceptionErreurPaiement("Votre compte présente un solde qui ne permet pas le réglement du devis présenté. Veuillez l'alimenter.");
		}
	}
	
	/**
	 * Opération de crédit d'un transporteur.
	 * 
	 * @param RIB Informations bancaire du transporteur à créditer.
	 * @param montant Montant à créditer.
	 */
	public void crediterTransport(String RIB, short montant) {
		short montant_vire = (short)(montant * 0.9);
		this.dbHelper.crediter(RIB, montant_vire);
		G_FacturationServeur.lgr.log(Level.INFO, montant_vire
				+ " ont été viré sur le RIB " + RIB);
	}
	
	/**
	 * Retourne le solde courant d'un compte bancaire.
	 * 
	 * @param RIB Informations bancaires nécessaires.
	 * @return Montant disponible sur le compte bancaire.
	 */
	public float getSolde(String RIB) {
		return this.dbHelper.getSolde(RIB);
	}

}
