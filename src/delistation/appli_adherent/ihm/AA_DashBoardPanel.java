package delistation.appli_adherent.ihm;

import java.awt.Color;

import delistation.utils.CorbaObjectFinder;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import delistation.datatypes.Adherent;
import delistation.datatypes.Course;
import delistation.exceptions.ExceptionAdherentInconnu;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.g_superviseur.G_Superviseur;
import delistation.g_adherents.G_Adherents;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AA_DashBoardPanel extends JPanel {
	
	Logger lgr = Logger.getLogger(AA_LoginPanel.class.getName());
	private AA_Modele modele;
	
	private JTable table;
	private static Color MY_GREEN = new Color(64, 205, 129);

	
	/**
	 * Create the panel.
	 * 
	 * @throws ExceptionColisInconnu
	 */
	public AA_DashBoardPanel(final Short numAdh)
			throws ExceptionColisInconnu {
		this.modele = AA_Modele.singleton;
		setBackground(MY_GREEN);
		setForeground(Color.BLACK);
		setBounds(0, 0, 321, 444);
		setLayout(null);

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Calibri", Font.BOLD, 49));
		lblDashboard.setBounds(10, 11, 301, 47);
		add(lblDashboard);

		G_Adherents g_adherents = CorbaObjectFinder.bind_G_Adherent();
		//Adherent currAdh = g_adherents.getAdherent(numAdh);

		// String fullName=currAdh.getPrenom()+" "+currAdh.getNom();
		JLabel lblNom = new JLabel("NOM");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNom.setBounds(10, 69, 172, 14);
		add(lblNom);

		final JLabel lblHistoriqueDesColis = new JLabel("Suivi des livraisons");
		lblHistoriqueDesColis.setForeground(Color.WHITE);
		lblHistoriqueDesColis.setFont(new Font("Calibri", Font.BOLD, 13));
		lblHistoriqueDesColis.setBounds(10, 95, 301, 14);
		add(lblHistoriqueDesColis);

		try {
			G_Superviseur g_superviseur = CorbaObjectFinder
					.bind_G_Superviseur();
			Course[] lCourse = g_superviseur.rechercheCourseEnCours(numAdh);
			if (lCourse.length == 0) {
				lblHistoriqueDesColis.setText("Aucun colis a afficher");
			} else {
				// Récupération des suivis
				String[] header = { "N°Colis", "Etat", "Date" };
				Object[][] data = AA_Utils.extractSCTableData(lCourse);
				
				table = new JTable(data, header);
				table.setBounds(6, 11, 280, 160);
				table.setColumnSelectionAllowed(true);
				table.setCellSelectionEnabled(true);
				table.setBorder(new LineBorder(MY_GREEN, 1, true));
				table.setBackground(Color.WHITE);
				table.setForeground(Color.BLACK);
				add(table);

				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setLocation(20, 121);
				scrollPane.setSize(280, 186);
				scrollPane.setBackground(Color.WHITE);
				scrollPane.setForeground(Color.BLACK);
				scrollPane.setColumnHeaderView(table.getTableHeader());
				add(scrollPane);
				
			}
		} catch (Exception e) {
			lblHistoriqueDesColis.setText("Erreur dans la recherche des colis");
		}
		
		JButton btnNewButton = new JButton("Rafraichir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					G_Superviseur g_superviseur = CorbaObjectFinder
							.bind_G_Superviseur();
					Course[] lCourse = g_superviseur.rechercheCourseEnCours(numAdh);
					if (lCourse.length == 0) {
						lblHistoriqueDesColis.setText("Aucun colis a afficher");
					} else {
						// Récupération des suivis
						String[] header = { "N°Colis", "Etat", "Date" };
						Object[][] data = AA_Utils.extractSCTableData(lCourse);
						
						table = new JTable(data, header);
						table.setBounds(6, 11, 280, 160);
						table.setColumnSelectionAllowed(true);
						table.setCellSelectionEnabled(true);
						table.setBorder(new LineBorder(MY_GREEN, 1, true));
						table.setBackground(Color.WHITE);
						table.setForeground(Color.BLACK);
						add(table);

						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setLocation(20, 121);
						scrollPane.setSize(280, 186);
						scrollPane.setBackground(Color.WHITE);
						scrollPane.setForeground(Color.BLACK);
						scrollPane.setColumnHeaderView(table.getTableHeader());
						add(scrollPane);
						
					}
				} catch (Exception e) {
					lblHistoriqueDesColis.setText("Erreur dans la recherche des colis");
				}
				
			}
		});
		btnNewButton.setBounds(102, 331, 116, 51);
		add(btnNewButton);
	}
}
