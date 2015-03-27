package delistation.utils;

import java.util.ArrayList;
import java.util.Hashtable;

import delistation.datatypes.Zone;

public class Topographie {
	
	Hashtable<String, ArrayList<String>> topographie;
	
	public Topographie() {
		this.topographie = new Hashtable<String, ArrayList<String>>();
		this.charger_topographie();
	}

	
	@SuppressWarnings("serial")
	private void charger_topographie() {
		
		final String zone11 = new Zone((short) 1, (short) 1).toString();
		final String zone12 = new Zone((short) 1, (short) 2).toString();
		final String zone21 = new Zone((short) 2, (short) 1).toString();
		final String zone22 = new Zone((short) 2, (short) 2).toString();
		final String zone31 = new Zone((short) 3, (short) 1).toString();
		final String zone32 = new Zone((short) 3, (short) 2).toString();
		
		this.topographie.put(zone11, new ArrayList<String>() {
			{
				add(zone21);
				add(zone22);
				add(zone31);
			}
		});
		
		this.topographie.put(zone12, new ArrayList<String>() {
			{
				add(zone21);
				add(zone22);
				add(zone31);
				add(zone32);
			}
		});
		this.topographie.put(zone21, new ArrayList<String>() {
			{
				add(zone11);
				add(zone12);
			}
		});
		this.topographie.put(zone22, new ArrayList<String>() {
			{
				add(zone11);
				add(zone12);
			}
		});
		this.topographie.put(zone31, new ArrayList<String>() {
			{
				add(zone11);
				add(zone12);
			}
		});
		this.topographie.put(zone32, new ArrayList<String>() {
			{
				add(zone11);
				add(zone12);
			}
		});
	};

	public boolean is_mitoyen(Zone zoneA, Zone zoneB) {
		ArrayList<String> z = this.topographie.get(zoneA.toString());
		if(z != null)
			return z.contains(zoneB.toString());
		else
			return false;
	}
}
