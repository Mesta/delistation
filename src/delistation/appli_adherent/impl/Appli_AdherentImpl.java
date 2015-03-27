package delistation.appli_adherent.impl;

import delistation.appli_adherent.Appli_AdherentPOA;
import delistation.appli_adherent.ihm.AA_Launcher;

;

public class Appli_AdherentImpl extends Appli_AdherentPOA {
	public Appli_AdherentImpl(){
		new AA_Launcher().run();
	}
	
	public void notifierColis() {


	}

}
