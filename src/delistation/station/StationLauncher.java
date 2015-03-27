package delistation.station;

import delistation.datatypes.Zone;
import delistation.station.ihm.StationJFrame;
import delistation.station.StationModele;

public class StationLauncher extends Thread{

	private Zone zone;

	public StationLauncher(Zone p_zone) {
		this.zone = p_zone;
	}
	
	public void run(){
		new StationModele(zone.commune, zone.quartier);
		new StationJFrame().setVisible(true);;
	}
	
	public static void main(String[] args){
		new StationLauncher(new Zone(Short.parseShort(args[0]), Short.parseShort(args[1]))).run();
	}
}
