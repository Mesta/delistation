package delistation.station.ihm.adherents;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import delistation.station.ihm.Utils;
import delistation.datatypes.Colis;
import delistation.station.StationModele;
import delistation.utils.CorbaObjectFinder;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.Hashtable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AdhActionRetraitPanel extends JPanel {
	private JTable table;
	private StationModele modele;

	/**
	 * Create the panel.
	 */
	public AdhActionRetraitPanel(StationModele station) {
		JPanel barre = new Adh_generic_Bar("Retrait");
		this.modele = StationModele.singleton;
		add(barre);

		setLayout(null);
		this.setBounds(0, 0, 626, 396);

		String message = "";
		Hashtable<Integer, Colis> aRetirer = station.getColisList(station
				.getCurrentAdh().no);
		if (aRetirer == null) {
			message = "Vous n'avez aucun colis à retirer";
		} else {
			int nbColis = aRetirer.size();
			if (nbColis == 0) {
				message = "Vous n'avez aucun colis à retirer";
			} else {
				message = "Vous avez " + nbColis + " colis à retirer";
			}
		}

		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setBounds(10, 65, 308, 14);
		add(lblNewLabel);

		/* if (aretirer) { */
		String[] header = { "N°Expediteur", "N°Colis", "N°Casier", "Action" };
		Object[][] data = Utils.extractSCTableData(aRetirer);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		final DefaultTableModel dtmTableModel = new DefaultTableModel(data, header);
		table = new JTable(dtmTableModel);
		
		table.setDefaultRenderer(String.class, centerRenderer);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		table.getColumnModel()
				.getColumn(3)
				.setCellRenderer(
						new Utils.ColorColumnRenderer(SystemColor.textHighlight));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowIndex = table.getSelectedRow();
				int colIndex = table.getSelectedColumn();
				if (colIndex == 3) {
					int noCasier = Integer.parseInt(table.getModel().getValueAt(rowIndex, 2).toString());
					short noColis = Short.parseShort(table.getModel().getValueAt(rowIndex, 1).toString());
					modele.removeColis(noCasier);
					dtmTableModel.removeRow(rowIndex);
					CorbaObjectFinder.bind_G_Superviseur().cloreTransport(noColis);
				}
			}
		});
		table.setBounds(122, 109, 378, 152);
		add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setLocation(20, 90);
		scrollPane.setSize(596, 295);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		add(scrollPane);
		// }

	}
}
