package pl.projektDB.model;

import pl.projektDB.beans.Produkt;


/**
 * Klasa do obs³ugi encji typu Rabat
 * 
 * @author krystianwieczorek@o2.pl
 *
 */
public class ProduktModel extends GenericModel {
	private static final long serialVersionUID = 1L;

	public String[] getFields() {
		return new String[] {"Produkt_id", "Nazwa_produktu", "Miara", "Data_modyfikacji", "Data_dodania", "Cena"};
	}
	public Object createEntity() {
		return new Produkt();
	}
	
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		if(columnIndex==5) return false;
//		return super.isCellEditable(rowIndex, columnIndex);
//	}

}
