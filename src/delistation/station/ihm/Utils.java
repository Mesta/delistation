package delistation.station.ihm;

import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import delistation.datatypes.Colis;

public class Utils {

	public static Object[][] extractSCTableData(Hashtable<Integer,Colis> lColis) {
		int i=0;
		Set<Integer>keySet = lColis.keySet();
		Object[][] tableData = new Object[keySet.size()][4];
		for (Integer currKey:keySet) {
			tableData[i][0]=lColis.get(currKey).expediteur;
			tableData[i][1]=lColis.get(currKey).noColis;
			tableData[i][2]=currKey;
			tableData[i][3]="Retirer";
			i++;
		}
		return tableData;
	}

	@SuppressWarnings("serial")
	public static class ColorColumnRenderer extends DefaultTableCellRenderer
	{
	   Color bkgndColor, fgndColor;
	     
	   public ColorColumnRenderer(Color foregnd) {
	      super();
	      fgndColor = foregnd;
	   }
	     
	   public Component getTableCellRendererComponent
	        (JTable table, Object value, boolean isSelected,
	         boolean hasFocus, int row, int column)
	   {
	      Component cell = super.getTableCellRendererComponent
	         (table, value, isSelected, hasFocus, row, column);
	  
	      cell.setBackground( bkgndColor );
	      cell.setForeground( fgndColor );
	      
	      return cell;
	   }
	}
	
	
}
