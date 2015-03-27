package delistation.g_colis.impl;

import delistation.datatypes.Colis;
import delistation.datatypes.etatColis;

public class ColisManager {

	private Colis colis;
	private etatColis etat;

	public ColisManager(Colis p_colis) {
		this.colis = p_colis;
	}

	public boolean isDestinaraire(short noAdh) {
		return (this.colis.destinataire == noAdh);
	}

	public void setEtatColis(etatColis p_etat) {
		this.etat = p_etat;
	}

	public etatColis getEtatColis() {
		return this.etat;
	}

	public Colis getColis() {
		return this.colis;
	}
}