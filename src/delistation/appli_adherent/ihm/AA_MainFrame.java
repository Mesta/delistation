package delistation.appli_adherent.ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AA_MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AA_MainFrame frame = new AA_MainFrame();
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
	public AA_MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 444);
		setPanel(new AA_LoginPanel(this));
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
