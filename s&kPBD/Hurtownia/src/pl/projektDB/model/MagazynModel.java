package pl.projektDB.model;

import pl.projektDB.beans.Magazyn;

/**
 * Klasa do obs³ugi encji typu Magazyn
 * 
 * @author krystianwieczorek@o2.pl
 *
 */
public class MagazynModel extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getFields() {
		return new String[] {"Magazyn_id", "Nazwa_magazynu", "Ulica"};
	}
	@Override
	public Object createEntity() {
		return new Magazyn();
	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if(columnIndex==5) return false;
//		return super.isCellEditable(rowIndex, columnIndex);
//	}

}
