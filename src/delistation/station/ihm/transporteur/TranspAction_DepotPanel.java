package delistation.station.ihm.transporteur;

import javax.swing.JPanel;
import javax.swing.JLabel;

import delistation.datatypes.Colis;
import delistation.datatypes.Course;
import delistation.datatypes.Zone;
import delistation.datatypes.etatColis;
import delistation.exceptions.ExceptionAdherentInconnu;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.exceptions.ExceptionCourseInconnue;
import delistation.exceptions.ExceptionMauvaisTransporteur;
import delistation.g_colis.G_Colis;
import delistation.station.StationModele;
import delistation.utils.CorbaObjectFinder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TranspAction_DepotPanel extends JPanel {
	private JTextField field_noCourse;
	private StationModele modele;

	/**
	 * Create the panel.
	 */
	public TranspAction_DepotPanel() {
		this.modele = StationModele.singleton;
		
		JPanel barre = new Trans_generic_Bar("Depôt");
		add(barre);
		setLayout(null);
		this.setBounds(0, 0, 626, 396);
		
		final JPanel panel = new JPanel();
		panel.setBounds(10, 65, 606, 314);
		add(panel);
		panel.setLayout(null);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 92, 286, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JLabel label_erreur = new JLabel("");
		label_erreur.setBounds(10, 67, 263, 14);
		panel_1.add(label_erreur);
		label_erreur.setForeground(Color.RED);
		
		field_noCourse = new JTextField();
		field_noCourse.setBounds(64, 36, 154, 20);
		panel_1.add(field_noCourse);
		field_noCourse.setColumns(10);
		
		JLabel lblNumroDeCourse = new JLabel("Num\u00E9ro de course");
		lblNumroDeCourse.setBounds(64, 11, 154, 14);
		panel_1.add(lblNumroDeCourse);
		
		JButton boutton_deposer = new JButton("D\u00E9poser");
		boutton_deposer.setBounds(129, 92, 89, 23);
		panel_1.add(boutton_deposer);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBounds(167, 104, 271, 105);
		panel_2.setLayout(null);
		
		final JLabel label_conf = new JLabel("");
		label_conf.setHorizontalAlignment(SwingConstants.CENTER);
		label_conf.setBounds(10, 67, 263, 14);
		panel_2.add(label_conf);
		
		boutton_deposer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (field_noCourse.getText().isEmpty()) {
					label_erreur.setText("Veuillez remplir tout les champs");
				} else {
					
					try {
						// Validation de la valeur numérique (via Exception NumberFormatException
						short noCourse = Short.parseShort(field_noCourse.getText());
						
						Course course = modele.g_superviseur().verifierTransporteur(modele.getCurrentTrans().noTransporteur, noCourse);

						//Verifier l'état du colis : il doit être en livraison
						G_Colis g_colis = CorbaObjectFinder.bind_G_Colis(course.IORG_Colis);
						etatColis etat = g_colis.demandeEtat(course.noColis);
						
						if(etat == etatColis.enTransport){
							
							//Verifier que c'est bien la bonne destination :
							//On récupère la zone du destinataire
							Colis colis = g_colis.getColis(course.noColis);
							Zone zoneDestColis 		= modele.g_adherents().getAdherent(colis.destinataire).adresse.zone;
							
							//On récupère la zone de la station courante
							Zone zoneCourante 	= modele.getZone();
							
							if(zoneDestColis.toString().equals(zoneCourante.toString())){
								//On récupère le numéro de casier
								int noCasier = modele.getCasierLibre();
								
								// Désactivation panel 1
								panel_1.setVisible(false);
								// Activation panel 2
							    String msgConf = "Vous pouvez déposer le colis n°" + course.noColis + " dans le casier n°" + noCasier;
							    label_conf.setText(msgConf);
								panel.add(panel_2);
								panel_2.setVisible(true);
								validate();
								repaint();
		
								//On simule le dépôt dans un casier
								modele.addColis(colis, noCasier);
								//On met à jour l'état du colis
								CorbaObjectFinder.bind_G_Superviseur().cloreTransport(course.noColis);								
							}
							else
								label_erreur.setText("Vous n'êtes pas à la bonne destination.");
						}
						else
							label_erreur.setText("Ce colis n'est pas censé être en transport");
						
					} catch (NumberFormatException e) {
						label_erreur.setText("Numéro de course invalide");
					} catch (ExceptionMauvaisTransporteur e) {
						label_erreur.setText("Cette course n'est pas la votre. Vous avez du vous tromper à la saisie !");
					} catch (ExceptionCourseInconnue e) {
						label_erreur.setText("Cette course n'est pas référencée dans le système");
					} catch (ExceptionColisInconnu e) {
						label_erreur.setText("Le colis est inconnu. WTF");
					} catch (ExceptionAdherentInconnu e) {
						label_erreur.setText("Une erreur est survenue durant le dépôt. Veuillez réessayer.");

					}
				}
			}
		});
	}
}
