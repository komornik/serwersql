package pl.projektDB.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import pl.projektDB.dao.GenericDAO;

/**
 * Uniwersalny i abstrakcyjny model danych dla JTable.
 * Aby go u�y� wystarczy przes�oni� dwie metody - getFields() i createEntity()
 * Patrz przyk�ad <link>CarModel</link> 
 * 
 * @author pawel@kasprowski.pl
 *
 */
public abstract class GenericModel extends AbstractTableModel { 
	private static final long serialVersionUID = 1L;


	/**
	 * Zwraca kolumy do wy�wietlania i nazwy p�l z encji do pobrania/zapisu
	 * 
	 * @return
	 */
	public abstract String[] getFields();

	/**
	 * Tworzenie nowego obiektu
	 * @return
	 */
	public abstract Object createEntity();

	/**
	 * DAO - �r�d�o danych
	 */
	GenericDAO dao;


	/**
	 * Lokalnie przechowywana lista obiekt�w. Co jakis czas synchronizowana z
	 * baz� metod� refresh().
	 */
	List<Object> entities = new ArrayList<Object>();

	/**
	 * Inicjalizacja lokalnej listy obiekt�w
	 */
	public GenericModel() {
		dao = new GenericDAO();
		refresh();
	}


	public int getColumnCount() {
		return getFields().length;
	}

	public int getRowCount() {
		return entities.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			Object obj = entities.get(rowIndex);
			Class<?> c = obj.getClass();
			// uruchomienie odpowiedniego gettera
			Method m = c.getDeclaredMethod("get" + getFields()[columnIndex]);
			return m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getColumnName(int columnIndex) {
		return getFields()[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// pierwsza kolumna to identyfikator - nie zmienia�!
		if(columnIndex>0) return true;
		return false;
	}

	@Override
	public void setValueAt(Object o, int rowIndex, int columnIndex) {
		try {
			Object object = entities.get(rowIndex);
			Class<?> c = object.getClass();
			// znalezienie ��danego typu obiektu dla settera
			Class<?> paramClass = ReflectionHelper.findParamClass(object, "set"	+ getFields()[columnIndex]);
			Object value = o;
			if(o instanceof String) {
				// konwersja Stringa na odpowiedni� klas�
				String txt = (String) o;
				value = ReflectionHelper.convertStringToClass(txt, paramClass);
			}
			// wywo�anie odpowiedniego settera dla obiektu
			Method mSet = c.getDeclaredMethod("set" + getFields()[columnIndex], paramClass);
			mSet.invoke(object, value);
			dao.update(object);
			refresh();
		} catch (Exception e) {
			// w przypadku b��du zmiana odrzucona i komunikat o b��dzie
			JOptionPane.showMessageDialog(null,
					"B��dna warto�� wpisana do pola!", "B��d",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Dodanie podanego obiektu do bazy
	 * 
	 * @param object
	 */
	public void add(Object object) {
		dao.create(object);
		// od�wie� list�
		refresh();
	}

	/**
	 * Dodanie do bazy nowego obiektu
	 */
	public void addNew() {
		add(createEntity());
	}

	/**
	 * Usuni�cie z bazy obiektu wy�wietlanego w tabeli na podanej pozycji
	 * 
	 * @param rowIndex
	 */
	public void del(int rowIndex) {
		Object object = entities.get(rowIndex);
		dao.delete(object);
		// od�wie� list� obiekt�w
		refresh();
	}

	/**
	 * Od�wie�a wygl�d tablicy
	 */
	public void refresh() {
		entities = dao.getAll(createEntity().getClass().getName());
		fireTableDataChanged();
	}
}
