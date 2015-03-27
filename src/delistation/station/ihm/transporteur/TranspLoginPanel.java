package delistation.station.ihm.transporteur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;

import delistation.datatypes.Transporteur;
import delistation.station.StationModele;
import delistation.station.ihm.SelectUserPanel;

public class TranspLoginPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -930210841019425408L;
	private JTextField field_login;
	private JTextField field_mdp;

	private JLabel label_error;
	
	private StationModele modele;

	/**
	 * Create the panel.
	 */
	public TranspLoginPanel(final StationModele station) {
		this.modele = StationModele.singleton;
		
		setLayout(null);

		this.setBounds(100, 100, 733, 513);

		JLabel title = new JLabel("Connexion");
		title.setFont(new Font("Calibri", Font.BOLD, 26));
		title.setBounds(10, 11, 170, 28);
		add(title);

		JPanel panel = new JPanel();
		panel.setBounds(195, 190, 342, 133);
		add(panel);
		panel.setLayout(null);

		JLabel label_login = new JLabel("Num\u00E9ro de transporteur");
		label_login.setBounds(0, 3, 148, 14);
		panel.add(label_login);

		JLabel label_noCourse = new JLabel("Mot de passe");
		label_noCourse.setBounds(0, 36, 148, 14);
		panel.add(label_noCourse);

		field_login = new JTextField();
		field_login.setBounds(170, 0, 172, 20);
		panel.add(field_login);
		field_login.setToolTipText("Votre identifiant de transporteur");
		field_login.setColumns(10);

		field_mdp = new JTextField();
		field_mdp.setBounds(170, 33, 172, 20);
		panel.add(field_mdp);
		field_mdp.setToolTipText("Votre mot de passe\r\n");
		field_mdp.setColumns(10);

		label_error = new JLabel("");
		label_error.setBounds(0, 77, 342, 14);
		panel.add(label_error);
		label_error.setForeground(Color.RED);

		final JButton button_connexion = new JButton("Connexion");
		button_connexion.setBounds(242, 102, 100, 31);
		panel.add(button_connexion);
		button_connexion.setEnabled(false);

		JButton button_annuler = new JButton("Annuler");
		button_annuler.setBounds(132, 102, 100, 31);
		panel.add(button_annuler);
		button_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				station.getIHM().setPanel(new SelectUserPanel(station));
			}
		});

		button_connexion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (field_login.getText().isEmpty()
						|| field_mdp.getText().isEmpty()) {
					label_error.setText("Veuillez remplir les champs");
				} else {
					short noTransp = Short.parseShort(field_login.getText());
					String MdP = field_mdp.getText();
					
					// Authentification
					if(modele.g_transporteur().authentifier(noTransp, MdP)){
						Transporteur cur = modele.g_transporteur().getTransporteur(noTransp);
						modele.setCurrentTrans(cur);
						station.getIHM().setPanel(new TranspAction_DepotPanel());
					}
					else
						label_error.setText("Vérifiez les informations saisies");
				}
			}
		});

		field_login.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					Integer.parseInt(field_login.getText());
					label_error.setText("");
					button_connexion.setEnabled(true);
				} catch (NumberFormatException e) {
					label_error
							.setText("Votre identifiant doit être une valeur numérique");
					button_connexion.setEnabled(false);
				}
			}
		});

		field_mdp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					if(field_mdp.getText() != ""){
						label_error.setText("");
						button_connexion.setEnabled(true);
					}
				} catch (Exception e) {
					label_error
							.setText("Le numéro de course doit être une valeur numérique");
					button_connexion.setEnabled(false);
				}
			}
		});
	}
}
