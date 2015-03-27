package delistation.appli_adherent.ihm;

import delistation.datatypes.Adherent;
import delistation.g_adherents.G_Adherents;
import delistation.utils.CorbaObjectFinder;


public class AA_Modele {
	public static AA_Modele singleton;
	private Adherent currentAdh;
	private G_Adherents g_adherents;
	
	public AA_Modele(){
		AA_Modele.singleton = this;
	}
	
	public G_Adherents g_adherents(){
		this.g_adherents = CorbaObjectFinder.bind_G_Adherent();
		return this.g_adherents;
	}
}
