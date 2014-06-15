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
 * Formatka zawieraj¹ca tablicê JTable i przyciski Dodaj, Usuñ
 * 
 * @author pawel@kasprowski.pl
 *
 */
public class TableFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	/**
	 * Table model jest wstrzykiwany - w zale¿noœci od jego klasy, tabelka bêdzie
	 * zawiera³a co innego!
	 */
	GenericModel tableModel;
	public void setTableModel(GenericModel tableModel) {
		this.tableModel = tableModel;
	}


	/**
	 * To musi byæ wystawione, ¿eby mo¿na by³o skorzystaæ w akcji usuñ 
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
		// dodanie przycisków
		contentPane.add(getPrzyciski(),BorderLayout.SOUTH);

		this.setSize(800, 600);
		this.setLocation(20, 20);
		this.setJMenuBar(new GenericMenu().getMenuBar());
		this.setLocationRelativeTo(null);
	}
	/**
	 * Generacja przycisków
	 * @return panel z przyciskami
	 */
	JPanel getPrzyciski() {
		JPanel pnPrzyciski = new JPanel();

		// Przycisk Dodaj
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(new Dimension(80,24));
		// wyœlij do modelu polecenie stworzenia nowego (pustego) samochodu
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.addNew();
			}
		});
		pnPrzyciski.add(btnDodaj);

		// Przycisk Usuñ
		JButton btnUsun = new JButton("Usuñ");
		btnUsun.setPreferredSize(new Dimension(80,24));
		// wyœlij do modelu polecenie usuniêcia zaznaczonego obiektu
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
