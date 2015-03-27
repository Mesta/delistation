package delistation.appli_adherent.ihm;

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
import delistation.exceptions.ExceptionColisInconnu;
import delistation.g_adherents.G_Adherents;
import delistation.utils.CorbaObjectFinder;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class AA_LoginPanel extends JPanel {
	private JTextField field_login;
	private JPasswordField field_pass;
	private AA_Modele modele;

	/**
	 * Create the panel.
	 */
	public AA_LoginPanel(final AA_MainFrame mainFrame) {
		this.modele = AA_Modele.singleton;
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

		JLabel label = new JLabel("Num\u00E9ro d'adh\u00E9rent");
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
		field_login.setToolTipText("Votre num\u00E9ro d'adh\u00E9rent");
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

		final JButton button_connexion = new JButton("Connexion");
		button_connexion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String pwd = new String(field_pass.getPassword());

				if (field_login.getText().isEmpty() || pwd.isEmpty()) {
					label_error.setText("Veuillez remplir les champs");
				} else {
					// Authentification
					short nAdh = Short.parseShort(field_login.getText());
					try {
						boolean resAuth = modele.g_adherents().authentifier(
								nAdh, pwd);
						if (resAuth) {
							// Authentifié
							mainFrame.setPanel(new AA_DashBoardPanel(nAdh));
						} else {
							// Non-Authentifié
							label_error.setText("Login / Password invalide.");
						}
					} catch (ExceptionColisInconnu e) {
						e.printStackTrace();
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
					int i = Integer.parseInt(field_login.getText());
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
