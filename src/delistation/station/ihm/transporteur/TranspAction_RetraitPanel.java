package delistation.station.ihm.transporteur;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import delistation.datatypes.Course;
import delistation.datatypes.etatColis;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.exceptions.ExceptionCourseInconnue;
import delistation.exceptions.ExceptionMauvaisTransporteur;
import delistation.station.StationModele;
import delistation.utils.CorbaObjectFinder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TranspAction_RetraitPanel extends JPanel {
	private JTextField field_noCourse;
	private StationModele modele;
	/**
	 * Create the panel.
	 * @param station 
	 */
	public TranspAction_RetraitPanel(StationModele station) {
		this.modele = StationModele.singleton;
		
		JPanel barre = new Trans_generic_Bar("Retrait de colis");
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
		
		field_noCourse = new JTextField();
		field_noCourse.setBounds(64, 36, 154, 20);
		panel_1.add(field_noCourse);
		field_noCourse.setColumns(10);
		
		JLabel lblNumroDeCourse = new JLabel("Num\u00E9ro de course");
		lblNumroDeCourse.setBounds(64, 11, 154, 14);
		panel_1.add(lblNumroDeCourse);
		
		JButton boutton_deposer = new JButton("Retirer le colis");
		boutton_deposer.setBounds(129, 92, 89, 23);
		panel_1.add(boutton_deposer);
		
		final JLabel label_erreur = new JLabel("");
		label_erreur.setBounds(10, 67, 263, 14);
		panel_1.add(label_erreur);
		label_erreur.setForeground(Color.RED);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBounds(45, 150, 516, 14);
		panel_2.setLayout(null);
		
		final JLabel label_conf = new JLabel("");
		label_conf.setHorizontalAlignment(SwingConstants.CENTER);
		label_conf.setBounds(0, 0, 516, 14);
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

						//On récupère le numéro de casier
						int noCasier = modele.getCasier(course.noColis);
						
						if(noCasier == -1)
							throw new ExceptionColisInconnu();
						
						//On vérifie si le transporteur est à l'heure
						if(modele.g_superviseur().estEnRetard(course.noCourse))
							label_erreur.setText("A la bourre !");
						else{

							// Sinon, on le retire du casier
							modele.removeColis(noCasier);
							// On met à jour l'état du colis
							CorbaObjectFinder.bind_G_Colis(course.IORG_Colis).majEtatColis(course.noColis, etatColis.enTransport);

							// On affiche le casier dans lequel récupérer le colis
							// Désactivation panel 1
							panel_1.setVisible(false);
							panel_1.setEnabled(false);
							// Activation panel 2
						    String msgConf = "Vous pouvez retirer le colis n°" + course.noColis + " dans le casier n°" + noCasier;
						    label_conf.setText(msgConf);
							panel.add(panel_2);
							panel_2.setVisible(true);
							validate();
							repaint();
						}
						
					} catch (NumberFormatException e) {
						label_erreur.setText("Le numéro de course doit être au format numérique.");
					} catch (ExceptionMauvaisTransporteur e) {
						label_erreur.setText("Cette course n'est pas la votre. Vous avez du vous tromper à la saisie !");
					} catch (ExceptionCourseInconnue e) {
						label_erreur.setText("Le numéro de course n'est pas référencé dans le système");
					} catch (ExceptionColisInconnu e) {
						label_erreur.setText("Ce colis n'est pas connu de cette station...");
					}
				}
			}
		});
	}
}
