package pl.projektDB.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;



import pl.projektDB.beans.Rabat;
/*import pl.kurs.beans.Owner;*/
import pl.projektDB.dao.GenericDAO;


/**
 * Formatka zawieraj�ca tablic� JTable i przyciski Dodaj, Usu�
 * 
 * @author 
 *
 */
public class UlicaFrame extends TableFrame{
	
	private static final long serialVersionUID = 1L;
	List<Rabat> kodyLista = new ArrayList<Rabat>();
	
	@Override
	public void addEditors() {
		
		GenericDAO dao = new GenericDAO();
		List<Object> kodyLista = dao.getAll("Kod_poczt");
		TableColumn col = tbl.getColumnModel().getColumn(2);
		col.setCellEditor(new DefaultCellEditor(new JComboBox(kodyLista.toArray())));
	}
	
	/**
	 * Generacja przycisk�w
	 * @return panel z przyciskami
	 */
	@Override
	public void addButtons(JPanel pnPrzyciski){
		

		// Przycisk Od�wie�
		JButton btnOdswiez = new JButton("Od�wie�");
		btnOdswiez.setPreferredSize(new Dimension(80,24));
		// od�wie�a list� 
		btnOdswiez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEditors();
			}
		});
		pnPrzyciski.add(btnOdswiez);

	
	}
	
	
}
