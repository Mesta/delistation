package delistation.appli_transporteur.ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AT_MainFrame extends JFrame {

	protected static AT_MainFrame singleton;
	
	private JPanel contentPane;
	AT_Modele modele;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AT_MainFrame frame = new AT_MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AT_MainFrame() {
		
		AT_MainFrame.singleton = this;
		this.modele = new AT_Modele();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 444);
		setPanel(new AT_LoginPanel(this));
	}

	public void setPanel(JPanel myPanel) {
		contentPane = myPanel;
		this.getContentPane().removeAll();
		this.getContentPane().add(contentPane);
		contentPane.revalidate();
		contentPane.repaint();
		// setContentPane(contentPane);
	}

}
