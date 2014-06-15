package pl.projektDB.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pl.projektDB.model.GenericMenu;
import pl.projektDB.model.GenericModel;


/**
 * Formatka zawieraj�ca tablic� JTable i przyciski Dodaj, Usu�
 * 
 * @author pawel@kasprowski.pl
 *
 */
public class TableFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	/**
	 * Table model jest wstrzykiwany - w zale�no�ci od jego klasy, tabelka b�dzie
	 * zawiera�a co innego!
	 */
	GenericModel tableModel;
	public void setTableModel(GenericModel tableModel) {
		this.tableModel = tableModel;
	}


	/**
	 * To musi by� wystawione, �eby mo�na by�o skorzysta� w akcji usu� 
	 */
	JTable tbl;

	/**
	 * Przygotowanie formatki
	 */
	public void init(String caption) {
		this.setTitle(caption);
		JPanel contentPane = (JPanel) this.getContentPane();
		// dodanie tabelki
		tbl = new JTable(tableModel);

		addEditors();
		
		contentPane.add(new JScrollPane(tbl),BorderLayout.CENTER);
		// dodanie przycisk�w
		contentPane.add(getPrzyciski(),BorderLayout.SOUTH);

		this.setSize(800, 600);
		this.setLocation(20, 20);
		this.setJMenuBar(new GenericMenu().getMenuBar());
		this.setLocationRelativeTo(null);
	}
	/**
	 * Generacja przycisk�w
	 * @return panel z przyciskami
	 */
	JPanel getPrzyciski() {
		JPanel pnPrzyciski = new JPanel();

		// Przycisk Dodaj
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(new Dimension(80,24));
		// wy�lij do modelu polecenie stworzenia nowego (pustego) samochodu
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.addNew();
			}
		});
		pnPrzyciski.add(btnDodaj);

		// Przycisk Usu�
		JButton btnUsun = new JButton("Usu�");
		btnUsun.setPreferredSize(new Dimension(80,24));
		// wy�lij do modelu polecenie usuni�cia zaznaczonego obiektu
		btnUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbl.getSelectedRow(); 
				if(index>=0) 
					tableModel.del(index);
			}
		});
		pnPrzyciski.add(btnUsun);

		addButtons(pnPrzyciski);
		
		
		return pnPrzyciski;
	}

	
	public void addEditors() {}
	
	public void addButtons(JPanel pnPrzyciski) {}
	
}
