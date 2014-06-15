package pl.projektDB;

import javax.swing.JFrame;


import pl.projektDB.model.GenericModel;
import pl.projektDB.ui.TableFrame;
import pl.projektDB.model.KlientModel;
import pl.projektDB.ui.KlientFrame;
import pl.projektDB.model.SingleSession;

/**
 * Klasa g³ówna startuj¹ca aplikacjê
 * 
 * @author pawel@kasprowski.pl
 *
 */
public class Start {
	public static void main(String[] args) {
		
		TableFrame klientTable = new KlientFrame();
		GenericModel model = new KlientModel();
		klientTable.setTableModel(model);
		klientTable.init("Lista klientów");
		klientTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		klientTable.setVisible(true);
		
		SingleSession.setActualModel(model);
		SingleSession.setActualFrame(klientTable);
	}
}