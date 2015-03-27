package delistation.station.ihm.transporteur;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import delistation.datatypes.Transporteur;
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

public class Trans_generic_Bar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2711311358287151007L;
	private StationModele modele;

	/**
	 * Create the panel.
	 */
	public Trans_generic_Bar(String titre) {
		setLayout(null);
		this.modele = StationModele.singleton;
		
		this.setBounds(0, 0, 708, 68);

		JLabel title = new JLabel(titre);
		title.setForeground(SystemColor.textHighlight);
		title.setFont(new Font("Calibri", Font.BOLD, 26));
		title.setBounds(10, 19, 170, 28);
		add(title);

		Transporteur currentTrans = modele.getCurrentTrans();
		String raisonS = "";
		String numTrans= "";

		if (currentTrans == null) {
			// On retourne au premier ecran
			modele.getIHM().setPanel(new SelectUserPanel(modele));
		} else {
			// C'est un Transporteur
			raisonS = currentTrans.raisonSociale;
			numTrans = Short.toString(modele.getCurrentTrans().noTransporteur);
		}

		JLabel label_raisonS = new JLabel(raisonS);
		label_raisonS.setHorizontalAlignment(SwingConstants.RIGHT);
		label_raisonS.setBounds(424, 11, 261, 14);
		add(label_raisonS);

		JLabel label_numero = new JLabel("Num\u00E9ro : " + numTrans);
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
				modele.getIHM().setPanel(new TranspAction_RetraitPanel(modele));
			}
		});
		button.setBackground(new Color(221, 160, 221));
		button.setBounds(247, 22, 107, 28);
		add(button);
		
		JButton button_1 = new JButton("D\u00E9pot");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Action depot
				modele.getIHM().setPanel(new TranspAction_DepotPanel());
			}
		});
		button_1.setBackground(new Color(102, 205, 170));
		button_1.setBounds(372, 22, 107, 28);
		add(button_1);
	}
}
