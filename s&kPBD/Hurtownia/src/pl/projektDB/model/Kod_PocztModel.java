package pl.projektDB.model;

import pl.projektDB.beans.Kod_poczt;


/**
 * Klasa do obs³ugi encji typu Kod_poczt
 * 
 * @author krystianwieczorek@o2.pl
 *
 */
public class Kod_PocztModel extends GenericModel {
	private static final long serialVersionUID = 1L;

	public String[] getFields() {
		return new String[] {"Kod_poczt_id", "Kod_poczt", "Nazwa_miejscowosci"};
	}
	public Object createEntity() {
		return new Kod_poczt();
	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if(columnIndex==5) return false;
//		return super.isCellEditable(rowIndex, columnIndex);
//	}

}
