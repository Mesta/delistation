package delistation.station.ihm.adherents;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import delistation.datatypes.Adherent;
import delistation.station.StationModele;
import delistation.station.ihm.SelectUserPanel;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Adh_generic_Bar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2711311358287151007L;
	private StationModele modele;

	/**
	 * Create the panel.
	 */
	public Adh_generic_Bar(String titre) {
		setLayout(null);
		this.modele = StationModele.singleton;
		this.setBounds(0, 0, 708, 68);

		JLabel title = new JLabel(titre);
		title.setForeground(SystemColor.textHighlight);
		title.setFont(new Font("Calibri", Font.BOLD, 26));
		title.setBounds(10, 19, 170, 28);
		add(title);

		Adherent currentAdh = modele.getCurrentAdh();
		String prenom = modele.getCurrentAdh().prenom;
		String fullName = prenom+" "+modele.getCurrentAdh().nom;
		String numAdh = Short.toString(modele.getCurrentAdh().no);

		if (currentAdh == null) {
			// On retourne au premier ecran
			modele.getIHM().setPanel(new SelectUserPanel(modele));
		} else {
			// C'est un adhérent
			prenom = currentAdh.prenom;
			fullName = prenom + " " + currentAdh.nom;
			numAdh = Short.toString(currentAdh.no);
		}

		JLabel label_nom_prenom = new JLabel(fullName);
		label_nom_prenom.setHorizontalAlignment(SwingConstants.RIGHT);
		label_nom_prenom.setBounds(424, 11, 261, 14);
		add(label_nom_prenom);

		JLabel label_numero = new JLabel("Num\u00E9ro : " + numAdh);
		label_numero.setHorizontalAlignment(SwingConstants.RIGHT);
		label_numero.setBounds(618, 29, 67, 14);
		add(label_numero);

		JLabel link_deconexion = new JLabel("D\u00E9connexion");
		link_deconexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modele.getIHM().setPanel(new SelectUserPanel(modele));
			}
		});
		link_deconexion.setHorizontalAlignment(SwingConstants.RIGHT);
		link_deconexion.setForeground(SystemColor.textHighlight);
		link_deconexion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		link_deconexion.setBounds(596, 46, 89, 14);
		add(link_deconexion);
		
		JButton button = new JButton("Retrait");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Action Retrait
				modele.getIHM().setPanel(new AdhActionRetraitPanel(modele));
			}
		});
		button.setBackground(new Color(221, 160, 221));
		button.setBounds(247, 22, 107, 28);
		add(button);
		
		JButton button_1 = new JButton("D\u00E9pot");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Action depot
				modele.getIHM().setPanel(new AdhActionDepotPanel_renseignements());
			}
		});
		button_1.setBackground(new Color(102, 205, 170));
		button_1.setBounds(372, 22, 107, 28);
		add(button_1);
	}
}
