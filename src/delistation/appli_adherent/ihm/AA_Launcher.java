package delistation.appli_adherent.ihm;

public class AA_Launcher extends Thread {
	
	
	public void run(){
		new AA_Modele();
		new AA_MainFrame().setVisible(true);
	}
	
	public static void main(String[] args){
		new AA_Launcher().run();
	}
}
