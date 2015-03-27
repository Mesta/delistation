package delistation.station.ihm;

import delistation.station.StationModele;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StationJFrame extends JFrame {

	private JPanel contentPane;
	private StationModele modele;

	/**
	 * Create the frame.
	 */
	public StationJFrame() {
		this.modele = StationModele.singleton;
		setTitle("Station de la zone " + modele.getZone().commune + " - " + modele.getZone().quartier);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 513);
		contentPane = new SelectUserPanel(modele);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		modele.setIHM(this);
	}

	public void setPanel(JPanel myPanel) {
		this.getContentPane().removeAll();
		contentPane = myPanel;
		this.getContentPane().add(contentPane);
		contentPane.revalidate();
		contentPane.repaint();
		setContentPane(contentPane);
	}

}
