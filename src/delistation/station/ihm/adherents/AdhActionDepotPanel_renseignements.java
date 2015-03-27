package delistation.station.ihm.adherents;

import javax.swing.JPanel;

import delistation.datatypes.Adresse;
import delistation.datatypes.Colis;
import delistation.datatypes.ColisHolder;
import delistation.datatypes.Zone;
import delistation.exceptions.ExceptionDestinataireInconnue;
import delistation.exceptions.ExceptionDestinationMemeZone;
import delistation.exceptions.ExceptionErreurPaiement;
import delistation.g_colis.G_Colis;
import delistation.station.StationModele;
import delistation.utils.CorbaObjectFinder;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AdhActionDepotPanel_renseignements extends JPanel {
	private JTextField field_nom;
	private JTextField field_prenom;
	private JTextField field_adresse_numero;
	private JTextField field_adresse_rue;
	
	private StationModele modele;
	/**
	 * Create the panel.
	 */
	public AdhActionDepotPanel_renseignements() {
		this.modele = StationModele.singleton;
		
		final JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(177, 145, 271, 105);
		
		JLabel label_7 = new JLabel("Livraison valid\u00E9e");
		label_7.setForeground(new Color(50, 205, 50));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_7.setBounds(0, 0, 271, 30);
		panel_2.add(label_7);
		
		final JLabel label_montant = new JLabel("Montant d\u00E9biter : ");
		label_montant.setBounds(10, 41, 127, 14);
		panel_2.add(label_montant);
		
		final JLabel label_casier = new JLabel("Casier de d\u00E9pot : ");
		label_casier.setBounds(10, 66, 127, 14);
		panel_2.add(label_casier);
		
		JLabel label_11 = new JLabel("Veuillez d\u00E9poser votre colis dans le casier indiqu\u00E9...");
		label_11.setBounds(10, 91, 251, 14);
		panel_2.add(label_11);
		
		JPanel barre = new Adh_generic_Bar("Dépot");
		add(barre);
		
		setLayout(null);
		this.setBounds(0, 0, 626, 396);
		
		final JPanel panel = new JPanel();
		panel.setBounds(10, 65, 606, 314);
		add(panel);
		panel.setLayout(null);

		final JLabel label_title_panel = new JLabel(
				"Information sur le destinataire");
		label_title_panel.setBounds(0, 0, 178, 14);
		panel.add(label_title_panel);

		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(179, 52, 248, 238);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JTextArea label_erreur = new JTextArea();
		label_erreur.setBackground(new Color(240,240,240));
		label_erreur.setForeground(Color.RED);
		label_erreur.setBounds(0, 154, 248, 44);
		label_erreur.setEditable(false);
		panel_1.add(label_erreur);

		JLabel label = new JLabel("Nom");
		label.setBounds(0, 3, 68, 14);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Pr\u00E9nom");
		label_1.setBounds(0, 28, 68, 14);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Adresse");
		label_2.setBounds(0, 53, 68, 14);
		panel_1.add(label_2);

		field_nom = new JTextField();
		field_nom.setColumns(10);
		field_nom.setBounds(78, 0, 170, 20);
		panel_1.add(field_nom);

		field_prenom = new JTextField();
		field_prenom.setColumns(10);
		field_prenom.setBounds(78, 25, 170, 20);
		panel_1.add(field_prenom);

		field_adresse_numero = new JTextField();
		field_adresse_numero.setColumns(10);
		field_adresse_numero.setBounds(78, 76, 44, 20);
		panel_1.add(field_adresse_numero);

		JLabel label_3 = new JLabel("Num\u00E9ro");
		label_3.setBounds(16, 79, 68, 14);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Rue");
		label_4.setBounds(16, 104, 68, 14);
		panel_1.add(label_4);

		field_adresse_rue = new JTextField();
		field_adresse_rue.setColumns(10);
		field_adresse_rue.setBounds(78, 101, 170, 20);
		panel_1.add(field_adresse_rue);

		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.setBounds(148, 209, 100, 28);
		panel_1.add(btnSuivant);
		
				final JLabel label_etape = new JLabel("Etape 1/2");
				label_etape.setBounds(0, 25, 77, 14);
				panel.add(label_etape);
				label_etape.setHorizontalAlignment(SwingConstants.LEFT);
				
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (field_nom.getText().isEmpty()
						|| field_prenom.getText().isEmpty()
						|| field_adresse_numero.getText().isEmpty()
						|| field_adresse_rue.getText().isEmpty()) {
					label_erreur.setText("Veuillez remplir tous les champs");
				} else {
					try {
						// Parsing et vérification des short
						int numero_rue = Integer.parseInt(field_adresse_numero.getText());
						// Composition de l'adresse de destination
						String fullname_format = field_prenom.getText()
								.replaceFirst(
										".",
										(field_prenom.getText().charAt(0) + "")
												.toUpperCase())+" "+field_nom.getText().replaceFirst(
								".",
								(field_nom.getText().charAt(0) + "")
										.toUpperCase());
						Zone zoneDest = new Zone ((short)0, (short)0);
						Adresse adrDest = new Adresse (fullname_format,(short)numero_rue, field_adresse_rue.getText(), zoneDest);
						
						//Récupération entité
					    G_Colis g_colis = CorbaObjectFinder.bind_G_Colis(modele.getZone());
					    
					    // Action Depot
					    Short nColis = 0;
					    // On simule l'action d'insertion du colis dans le casier
					    Colis tmp = new Colis(nColis, modele.getCurrentAdh().no,(short)0);
					    ColisHolder colisHolder = new ColisHolder(tmp);
					    
					    Short montant = g_colis.deposer(adrDest, colisHolder);
					    
					    int noCasier = modele.getCasierLibre(); 
					    modele.addColis(colisHolder.value, noCasier);
					    
					    /* Etape 2 */
						// Desactivation panel 1
						panel_1.setVisible(false);
						panel.remove(panel_1);
						// Ecriture des Informations
						label_montant.setText(label_montant.getText() + Short.toString(montant));
						label_casier.setText(label_casier.getText() + noCasier);
						// Activation panel 2
						label_title_panel.setText("Confirmation de dépot");
						label_etape.setText("Etape 2/2");
						panel.add(panel_2);
						panel_2.setVisible(true);
						validate();
						repaint();
						
					} catch (NumberFormatException e) {
						label_erreur.setText("Certaines valeurs doivent être numériques");
					} catch (ExceptionDestinationMemeZone e) {
						label_erreur.setText("Le destinataire est dans la même zone que vous");
					} catch (ExceptionErreurPaiement e) {
						label_erreur.setText("Vous n'avez plus de crédit");
					} catch (ExceptionDestinataireInconnue e) {
						label_erreur.setText("Le destinataire est inconnu");
					}
				}
			}
		});
	}
}
