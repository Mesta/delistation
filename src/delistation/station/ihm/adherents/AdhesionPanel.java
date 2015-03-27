package delistation.station.ihm.adherents;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.omg.CORBA.StringHolder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import delistation.exceptions.ExceptionAdresseDejaPrise;
import delistation.exceptions.ExceptionErreurInscription;
import delistation.exceptions.ExceptionErreurPaiement;
import delistation.g_adherents.G_Adherents;
import delistation.station.StationModele;
import delistation.station.ihm.SelectUserPanel;
import delistation.utils.CorbaObjectFinder;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class AdhesionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4215774317109033070L;
	private JTextField field_nom;
	private JTextField field_prenom;
	private JTextField field_adresse_numero;
	private JTextField field_adresse_rue;
	private JTextField field_rib;

	/**
	 * Create the panel.
	 */
	public AdhesionPanel(final StationModele station) {
		setLayout(null);

		this.setBounds(100, 100, 733, 513);

		JLabel title = new JLabel("Adhesion");
		title.setForeground(SystemColor.textHighlight);
		title.setFont(new Font("Calibri", Font.BOLD, 26));
		title.setBounds(10, 11, 170, 28);
		add(title);
		final JPanel panel_confirmation = new JPanel();
		panel_confirmation.setBounds(186, 183, 361, 147);
		panel_confirmation.setLayout(null);

		final JLabel lblInformations = new JLabel("Informations ");
		lblInformations.setBounds(242, 107, 99, 14);
		add(lblInformations);

		final JPanel panel_formulaire = new JPanel();
		panel_formulaire.setBounds(242, 132, 248, 265);
		add(panel_formulaire);
		panel_formulaire.setLayout(null);

		JLabel label_nom = new JLabel("Nom");
		label_nom.setBounds(0, 3, 68, 14);
		panel_formulaire.add(label_nom);

		JLabel label_prenom = new JLabel("Pr\u00E9nom");
		label_prenom.setBounds(0, 28, 68, 14);
		panel_formulaire.add(label_prenom);

		JLabel label_adresse = new JLabel("Adresse");
		label_adresse.setBounds(0, 78, 68, 14);
	panel_formulaire.add(label_adresse);

		field_nom = new JTextField();
		field_nom.setBounds(78, 0, 170, 20);
		panel_formulaire.add(field_nom);
		field_nom.setColumns(10);

		field_prenom = new JTextField();
		field_prenom.setBounds(78, 25, 170, 20);
		panel_formulaire.add(field_prenom);
		field_prenom.setColumns(10);

		field_adresse_numero = new JTextField();
		field_adresse_numero.setBounds(78, 101, 44, 20);
		panel_formulaire.add(field_adresse_numero);
		field_adresse_numero.setColumns(10);

		JLabel label_adresse_numero = new JLabel("Num\u00E9ro");
		label_adresse_numero.setBounds(16, 104, 68, 14);
		panel_formulaire.add(label_adresse_numero);

		JLabel label_adresse_rue = new JLabel("Rue");
		label_adresse_rue.setBounds(16, 129, 68, 14);
		panel_formulaire.add(label_adresse_rue);

		field_adresse_rue = new JTextField();
		field_adresse_rue.setBounds(78, 126, 170, 20);
		panel_formulaire.add(field_adresse_rue);
		field_adresse_rue.setColumns(10);

		JLabel label_zone = new JLabel("Zone");
		label_zone.setBounds(16, 154, 46, 14);
		panel_formulaire.add(label_zone);

		JLabel label_zone_value = new JLabel(station.getZone().commune + " - "
				+ station.getZone().quartier);
		label_zone_value.setBounds(78, 154, 154, 14);
		panel_formulaire.add(label_zone_value);

		JLabel label = new JLabel("RIB");
		label.setBounds(0, 53, 68, 14);
		panel_formulaire.add(label);

		field_rib = new JTextField();
		field_rib.setBounds(78, 50, 170, 20);
		panel_formulaire.add(field_rib);
		field_rib.setColumns(10);

		final JButton bouton_adherer = new JButton("Adh\u00E9rer");
		bouton_adherer.setBounds(148, 230, 100, 28);
		panel_formulaire.add(bouton_adherer);

		JButton bouton_annuler = new JButton("Annuler");
		bouton_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				station.getIHM().setPanel(new SelectUserPanel(station));
			}
		});
		bouton_annuler.setBounds(38, 230, 100, 28);
		panel_formulaire.add(bouton_annuler);

		/* Confirmation */
		field_nom.setText("Pousson-Ribis");
		field_prenom.setText("Nicolas");
		field_adresse_numero.setText("80");
		field_adresse_rue.setText("Du Merge");
		field_rib.setText("123456789");
		
		final JTextArea label_erreur = new JTextArea();
		label_erreur.setBounds(0, 179, 248, 40);
		panel_formulaire.add(label_erreur);
		label_erreur.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_erreur.setForeground(Color.RED);
		label_erreur.setEditable(false);
		label_erreur.setBackground(new Color(240,240,240));

		// Confirmation
		JLabel label_message = new JLabel(
				"F\u00E9licitations, vous \u00EAtes maintenant adh\u00E9rent chez DeliStation :)");
		label_message.setBounds(0, 0, 361, 28);
		panel_confirmation.add(label_message);
		label_message.setHorizontalAlignment(SwingConstants.CENTER);

		final JLabel label_numAdh = new JLabel("Num\u00E9ro d'adh\u00E9rent : ");
		label_numAdh.setBounds(28, 39, 189, 14);
		panel_confirmation.add(label_numAdh);

		final JLabel label_pass = new JLabel("Password : ");
		label_pass.setBounds(74, 64, 139, 14);
		panel_confirmation.add(label_pass);

		final JLabel label_montant = new JLabel("Montant d\u00E9bit\u00E9 : ");
		label_montant.setHorizontalAlignment(SwingConstants.LEFT);
		label_montant.setBounds(47, 89, 170, 14);
		panel_confirmation.add(label_montant);
		panel_confirmation.setVisible(true);
		
		JButton button_OK = new JButton("OK");
		button_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				station.getIHM().setPanel(new SelectUserPanel(station));
			}
		});
		button_OK.setBounds(262, 113, 89, 23);
		panel_confirmation.add(button_OK);

		bouton_adherer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				short montant = 0;
				if (field_nom.getText().isEmpty()
						|| field_prenom.getText().isEmpty()
						|| field_adresse_numero.getText().isEmpty()
						|| field_adresse_rue.getText().isEmpty()
						|| field_rib.getText().isEmpty()) {
					label_erreur.setText("Veuillez remplir tout les champs");
				} else {
					G_Adherents g_adherents = CorbaObjectFinder
							.bind_G_Adherent();
					StringHolder numAdh = new StringHolder(new String(""));
					StringHolder mdP = new StringHolder(new String(""));
					try {
						String nom_format = field_nom.getText().replaceFirst(
								".",
								(field_nom.getText().charAt(0) + "")
										.toUpperCase());
						String prenom_format = field_prenom.getText()
								.replaceFirst(
										".",
										(field_prenom.getText().charAt(0) + "")
												.toUpperCase());

						String adresse_format = prenom_format + " "
								+ nom_format + ";"
								+ field_adresse_numero.getText() + ";Rue "
								+ field_adresse_rue.getText() + ";1;1";
						String RIB = field_rib.getText();

						// Demande d'adhesion
						montant = g_adherents
								.adherer(nom_format, prenom_format,
										adresse_format, RIB, numAdh, mdP);
					} catch (ExceptionErreurInscription e) {
						label_erreur
								.setText("Une erreur inconnue est survenue durant l'inscription.");
					} catch (ExceptionErreurPaiement e) {
						label_erreur
								.setText("Une erreur est survenue durant le paiement de l'adhésion. Raison : "
										+ e.raison);
					} catch (ExceptionAdresseDejaPrise e) {
						label_erreur
								.setText("Un compte existe déjà pour l'adresse de livraison que vous avez spécifié.");
					}

					// Desactivation formulaire
					panel_formulaire.setVisible(false);
					lblInformations.setVisible(false);
					panel_formulaire.setEnabled(false);
					// Activation confirmation
					label_numAdh.setText(label_numAdh.getText() + numAdh.value);
					label_pass.setText(label_pass.getText() + mdP.value);
					label_montant.setText(label_montant.getText()+montant+" Euro");
					add(panel_confirmation);
					panel_confirmation.setVisible(true);
					validate();
					repaint();
				}
			}
		});
	}
}
