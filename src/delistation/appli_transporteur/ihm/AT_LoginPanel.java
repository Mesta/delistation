package delistation.appli_transporteur.ihm;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.logging.Level;

import delistation.exceptions.ExceptionColisInconnu;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class AT_LoginPanel extends JPanel {
	static public AT_LoginPanel singleton;

	private JTextField field_login;
	private JPasswordField field_pass;

	/**
	 * Create the panel.
	 */
	public AT_LoginPanel(final AT_MainFrame mainFrame) {
		AT_LoginPanel.singleton = this;

		setBackground(new Color(64, 205, 129));
		setForeground(Color.BLACK);
		setBounds(0, 0, 321, 444);
		setLayout(null);

		final JLabel label_error = new JLabel("");
		label_error.setBounds(5, 251, 310, 14);
		add(label_error);
		label_error.setHorizontalAlignment(SwingConstants.CENTER);
		label_error.setForeground(new Color(204, 51, 51));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 205, 129));
		panel.setBounds(74, 138, 172, 168);
		add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Num\u00E9ro de transporteur");
		label.setFont(new Font("Calibri", Font.BOLD, 13));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(0, 0, 172, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Mot de passe");
		label_1.setFont(new Font("Calibri", Font.BOLD, 13));
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(0, 56, 172, 14);
		panel.add(label_1);

		field_login = new JTextField();
		field_login.setBounds(0, 24, 172, 20);
		panel.add(field_login);
		field_login.setToolTipText("Votre num\u00E9ro de transporteur");
		field_login.setColumns(10);

		field_pass = new JPasswordField();
		field_pass.setBounds(0, 81, 172, 20);
		panel.add(field_pass);

		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 49));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 301, 47);
		add(lblNewLabel);

		/************************************/
		/** Clique sur le bouton Connexion **/
		/************************************/
		final JButton button_connexion = new JButton("Connexion");
		button_connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				short noTra = Short.parseShort(field_login.getText());
				String MdP = new String(field_pass.getPassword());
				
				if (field_login.getText().isEmpty() || MdP.isEmpty()) {
					label_error.setText("Veuillez remplir les champs");
				} else {

					// Authentification
					try {
						boolean resAuth = AT_MainFrame.singleton.modele
								.g_transporteur().authentifier(noTra, MdP);

						if (resAuth) { // Authentifié
							mainFrame.setPanel(new AT_DashBoardPanel(
									mainFrame, noTra));
						} else
							// Non-Authentifié
							label_error.setText("Login / Password invalide.");

					} catch (ExceptionColisInconnu e) {
						AT_Modele.lgr.log(Level.SEVERE,
								e.getMessage(), e);
					}
					catch(Exception e){
						label_error.setText("Une erreur survenue est survenue.");
						AT_Modele.lgr.log(Level.SEVERE,
								e.getMessage(), e);
					}
				}
			}
		});
		button_connexion.setFont(new Font("Calibri", Font.BOLD, 13));
		button_connexion.setBounds(36, 137, 100, 31);
		panel.add(button_connexion);

		field_login.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					label_error.setText("");
					button_connexion.setEnabled(true);
				} catch (Exception e) {
					label_error
							.setText("Votre identifiant n'est pas numérique");
					button_connexion.setEnabled(false);
				}
			}
		});
	}
}
