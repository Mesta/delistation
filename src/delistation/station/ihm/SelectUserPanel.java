package delistation.station.ihm;

import delistation.station.ihm.adherents.AdhLoginPanel;
import delistation.station.ihm.adherents.AdhesionPanel;
import delistation.station.ihm.transporteur.TranspLoginPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import delistation.station.StationModele;

import java.awt.SystemColor;

public class SelectUserPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8998567025291722351L;

	/**
	 * Create the panel.
	 */
	public SelectUserPanel(final StationModele station) {
		setLayout(null);
		
		this.setBounds(100, 100, 733, 513);

		JLabel lblBonjour = new JLabel("Bonjour");
		lblBonjour.setForeground(SystemColor.textHighlight);
		lblBonjour.setFont(new Font("Calibri", Font.BOLD, 26));
		lblBonjour.setBounds(10, 11, 216, 24);
		lblBonjour.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblBonjour);

		JPanel panel = new JPanel();
		panel.setBounds(275, 192, 182, 128);
		add(panel);
		panel.setLayout(null);

		JButton button_adh = new JButton("Je suis un adh\u00E9rent");
		button_adh.setBounds(0, 0, 182, 46);
		panel.add(button_adh);

		JButton button_trans = new JButton("Je suis un transporteur");
		button_trans.setBounds(0, 57, 182, 46);
		panel.add(button_trans);

		JLabel label_adhesion = new JLabel("Pas encore inscrit ?");
		label_adhesion.setHorizontalAlignment(SwingConstants.RIGHT);
		label_adhesion.setBounds(0, 114, 182, 14);
		panel.add(label_adhesion);
		label_adhesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				station.getIHM().setPanel(new AdhesionPanel(station));
			}
		});
		label_adhesion.setForeground(new Color(0, 102, 255));
		button_trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				station.getIHM().setPanel(new TranspLoginPanel(station));
			}
		});
		button_adh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				station.getIHM().setPanel(new AdhLoginPanel(station));
			}
		});

	}
}
