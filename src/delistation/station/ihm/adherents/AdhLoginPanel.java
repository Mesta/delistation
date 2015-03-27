package delistation.station.ihm.adherents;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import delistation.datatypes.Adherent;
import delistation.exceptions.ExceptionAdherentInconnu;
import delistation.g_adherents.G_Adherents;
import delistation.utils.CorbaObjectFinder;
import delistation.station.StationModele;
import delistation.station.ihm.SelectUserPanel;

import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AdhLoginPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 64684054496907758L;
	private JTextField field_login;
	private JTextField field_pass;
	private G_Adherents g_adherents;
	/**
	 * Create the panel.
	 */
	public AdhLoginPanel(final StationModele station) {

		g_adherents = CorbaObjectFinder.bind_G_Adherent();

		setLayout(null);
		this.setBounds(100, 100, 733, 513);

		JLabel title = new JLabel("Connexion");
		title.setForeground(SystemColor.textHighlight);
		title.setFont(new Font("Calibri", Font.BOLD, 26));
		title.setBounds(10, 11, 170, 28);
		add(title);

		JPanel panel = new JPanel();
		panel.setBounds(196, 195, 340, 123);
		add(panel);
		panel.setLayout(null);

		JLabel label_login = new JLabel("Num\u00E9ro d'adh\u00E9rent");
		label_login.setBounds(0, 3, 111, 14);
		panel.add(label_login);

		JLabel label_pass = new JLabel("Mot de passe");
		label_pass.setBounds(0, 36, 111, 14);
		panel.add(label_pass);

		field_login = new JTextField();
		field_login.setBounds(168, 0, 172, 20);
		panel.add(field_login);
		field_login.setToolTipText("Votre num\u00E9ro d'adh\u00E9rent");
		field_login.setColumns(10);

		field_pass = new JTextField();
		field_pass.setBounds(168, 33, 172, 20);
		panel.add(field_pass);
		field_pass.setToolTipText("Votre mot de passe\r\n");
		field_pass.setColumns(10);

		final JLabel label_error = new JLabel("");
		label_error.setBounds(0, 67, 340, 14);
		panel.add(label_error);
		label_error.setForeground(Color.RED);

		final JButton button_connexion = new JButton("Connexion");
		button_connexion.setBounds(240, 92, 100, 31);
		panel.add(button_connexion);

		JButton button_annuler = new JButton("Annuler");
		button_annuler.setBounds(132, 92, 100, 31);
		panel.add(button_annuler);

		button_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				station.getIHM().setPanel(new SelectUserPanel(station));
			}
		});

		button_connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (field_login.getText().isEmpty()
						|| field_pass.getText().isEmpty()) {
					label_error.setText("Veuillez remplir les champs");
				} else {
					short nAdh = new Short(field_login.getText()).shortValue();
					String pwd = field_pass.getText();

					// Authentification
					boolean resAuth = g_adherents.authentifier(nAdh, pwd);
					if (resAuth) {
						// Authentifié
						try {
							Adherent adh = g_adherents.getAdherent(nAdh);
							station.setCurrentAdh(adh);
							station.getIHM().setPanel(
									new AdhActionDepotPanel_renseignements());
						} catch (ExceptionAdherentInconnu e) {
							label_error.setText("Adhérent inconnu.");
						}
					} else {
						// Non-Authentifié
						label_error.setText("Login / Password invalide.");
					}
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
				} catch (Exception e) {
					label_error
							.setText("Votre identifiant doit être une valeur numérique");
					button_connexion.setEnabled(false);
				}
			}
		});

	}
}
