package delistation.appli_transporteur.ihm;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import delistation.appli_transporteur.ihm.AT_Utils;
import delistation.datatypes.Course;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.exceptions.ExceptionCourseDejaPrise;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;

public class AT_DashBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private AT_Modele modele;
	private static Color MY_GREEN = new Color(64, 205, 129);

	/**
	 * Create the panel.
	 * 
	 * @throws ExceptionColisInconnu
	 */
	public AT_DashBoardPanel(final AT_MainFrame mainFrame,
			Short noTransp) throws ExceptionColisInconnu {
		this.modele = AT_Modele.singleton;

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

		this.modele.setTransporteur(this.modele.g_transporteur().getTransporteur(noTransp));

		JLabel lblNom = new JLabel(this.modele.getTransporteur().raisonSociale);
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNom.setBounds(10, 69, 172, 14);
		add(lblNom);

		final JLabel label_courseAttente = new JLabel("Courses en attente");
		label_courseAttente.setForeground(Color.WHITE);
		label_courseAttente.setFont(new Font("Calibri", Font.BOLD, 13));
		label_courseAttente.setBounds(10, 95, 301, 14);
		add(label_courseAttente);

		final JLabel label_info = new JLabel("");
		label_info.setForeground(new Color(220, 20, 60));
		label_info.setBounds(20, 318, 280, 14);
		add(label_info);

		// Récupération des courses en attentes
		this.modele.setLesCourses(this.modele.g_transporteur().getCoursesEnAttente());

		/* Tableau */
		final DefaultTableModel dtmTableModel = new DefaultTableModel();
		final String[] header = { "N°Course", "Expedition", "Destination", "Gratification" };
		
		if ( this.modele.getLesCourses().length!=0) {
			// Info du Tableau
			Object[][] data = AT_Utils.extractSCTableData(this.modele.getLesCourses());
	
			// Modele du tableau
			dtmTableModel.setDataVector(data, header);
			
			// Création du Tableau
			table = new JTable(dtmTableModel);
			table.getColumnModel().getColumn(0).setResizable(true);
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
		} else {
			label_courseAttente.setText("Aucune course en attente");
		}
		
		JButton btnNewButton = new JButton("Rafraichir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Récupération des courses en attentes
				modele.setLesCourses(modele.g_transporteur().getCoursesEnAttente());
				Course[] lCourse = modele.getLesCourses();
				if (lCourse.length == 0 ) {
					label_courseAttente.setText("Aucune course en attente");
					dtmTableModel.setRowCount(0);
				} else {
					try {
						dtmTableModel.setDataVector(AT_Utils.extractSCTableData(modele.getLesCourses()), header);
					} catch (ExceptionColisInconnu e) {
						label_info.setText("Colis inconnu");
						dtmTableModel.setRowCount(0);
					}
				}
			}
		});
		btnNewButton.setBounds(102, 343, 116, 51);
		add(btnNewButton);

		JLabel lblDconnexion = new JLabel("D\u00E9connexion");
		lblDconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainFrame.setPanel(new AT_LoginPanel(mainFrame));
			}
		});
		lblDconnexion.setForeground(Color.WHITE);
		lblDconnexion.setBounds(108, 405, 104, 14);
		add(lblDconnexion);
		if(table != null){
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int rowIndex = table.getSelectedRow();

					// Action : Course selectionnée
					short nCourse = Short.parseShort("" + table.getModel().getValueAt(rowIndex, 0));
					Course course = AT_MainFrame.singleton.modele.getUneCourse(nCourse);
					
					course.noTransp = AT_MainFrame.singleton.modele.getTransporteur().noTransporteur;
					try {
						AT_MainFrame.singleton.modele.g_superviseur().enregistrerPriseEnCharge(course);
						AT_Utils.changeLabel(label_info, Color.WHITE, "La course "
							+ nCourse + " vous est réservée !");
						dtmTableModel.setRowCount(0);
					} catch (ExceptionCourseDejaPrise e) {
						AT_Utils.changeLabel(label_info,Color.RED,"Cette course n'est plus disponible");
					}
				}
			});
		}
	}
}
