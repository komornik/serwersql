package pl.projektDB.model;

import pl.projektDB.beans.Klient;

/**
 * Klasa do obs³ugi encji typu Klient
 * 
 * @author krystianwieczorek@o2.pl
 *
 */
public class KlientModel extends GenericModel {
	private static final long serialVersionUID = 1L;

	public String[] getFields() {
		return new String[] {"Klient_id", "Imie", "Nazwisko", "Nip", "Regon", "Telefon", "Rabat", "Ulica"};
	}
	public Object createEntity() {
		return new Klient();
	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if(columnIndex==5) return false;
//		return super.isCellEditable(rowIndex, columnIndex);
//	}

}
