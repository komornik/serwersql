package pl.projektDB.model;

import pl.projektDB.beans.Ulica;


/**
 * Klasa do obs³ugi encji typu Rabat
 * 
 * @author krystianwieczorek@o2.pl
 *
 */
public class UlicaModel extends GenericModel {
	private static final long serialVersionUID = 1L;

	public String[] getFields() {
		return new String[] {"Ulica_id", "Nazwa_ulicy", "Kod_poczt"};
	}
	public Object createEntity() {
		return new Ulica();
	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if(columnIndex==5) return false;
//		return super.isCellEditable(rowIndex, columnIndex);
//	}

}
