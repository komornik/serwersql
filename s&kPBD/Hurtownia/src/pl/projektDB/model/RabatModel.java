package pl.projektDB.model;

import pl.projektDB.beans.Rabat;

/**
 * Klasa do obs³ugi encji typu Rabat
 * 
 * @author krystianwieczorek@o2.pl
 *
 */
public class RabatModel extends GenericModel {
	private static final long serialVersionUID = 1L;

	public String[] getFields() {
		return new String[] {"Rabat_id", "Wysokosc"};
	}
	public Object createEntity() {
		return new Rabat();
	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if(columnIndex==5) return false;
//		return super.isCellEditable(rowIndex, columnIndex);
//	}

}
