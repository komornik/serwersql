package pl.projektDB.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pl.projektDB.ui.Kod_PocztFrame;
import pl.projektDB.ui.MagazynFrame;
import pl.projektDB.ui.ProduktFrame;
import pl.projektDB.ui.RabatFrame;
import pl.projektDB.ui.TableFrame;
import pl.projektDB.ui.UlicaFrame;




public class GenericMenu extends JMenuBar implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem[] items = new JMenuItem[15];
	private JMenu subMenuAdres;
	private JMenu subMenuMagazyn;

	
	
	public JMenuBar getMenuBar(){
		
		/** Elementy menu g³ównego */
		String[] nameMenu = {"Klient", "Rabat", "Adres", "Miejscowoœæ", "Ulica", "Faktura", "Produkt", "Stany Magazynowe", "Przychody", "Rozchody", "Magazyn"};
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Us³ugi hurtowni");
		
		for(int i = 0; i < nameMenu.length; i++){
				
			if(i == 2){
				subMenuAdres = new JMenu(nameMenu[i]);
				menu.add(subMenuAdres);
			}else if(i == 3 || i == 4){
				items[i] = new JMenuItem(nameMenu[i]);
				items[i].addActionListener(this);
				subMenuAdres.add(items[i]);
			}else if(i == 7){
				subMenuMagazyn = new JMenu(nameMenu[i]);
				menu.add(subMenuMagazyn);
			}else if(i > 7){
				items[i] = new JMenuItem(nameMenu[i]);
				items[i].addActionListener(this);
				subMenuMagazyn.add(items[i]);
			}else{
				items[i] = new JMenuItem(nameMenu[i]);
				items[i].addActionListener(this);
				menu.add(items[i]);
			}
		}
		
		
		menuBar.add(menu);	
		
		return menuBar;
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == items[0]){
			/*SingleSession.getActualFrame().setTitle("Klient");*/
		}else if(e.getSource() == items[1]){
			
			
/*			SingleSession.getActualFrame().setTitle("Rabat");
			SingleSession.setActualFrame(new RabatFrame());
			SingleSession.setActualModel(new RabatModel());
			SingleSession.getActualFrame().setTableModel(SingleSession.getActualModel());
			SingleSession.getActualFrame().init("Rabat");
			SingleSession.getActualFrame().setVisible(true);*/			
			
			TableFrame rabatTable = new RabatFrame();
			GenericModel model = new RabatModel();
			rabatTable.setTableModel(model);
			rabatTable.init("Lista rabatów");
			rabatTable.setVisible(true);			
			
		}else if(e.getSource() == items[3]){
			
			
			TableFrame kodPocztTable = new Kod_PocztFrame();
			GenericModel model = new Kod_PocztModel();
			kodPocztTable.setTableModel(model);
			kodPocztTable.init("Lista miejscowoœci");
			kodPocztTable.setVisible(true);			
			
		}else if(e.getSource() == items[4]){
			
			TableFrame ulicaTable = new UlicaFrame();
			GenericModel model = new UlicaModel();
			ulicaTable.setTableModel(model);
			ulicaTable.init("Lista ulic");
			ulicaTable.setVisible(true);	
			
		}else if(e.getSource() == items[5]){
			
			SingleSession.getActualFrame().setTitle("Faktura");
			
		}else if(e.getSource() == items[6]){
			
			
			TableFrame produktTable = new ProduktFrame();
			GenericModel model = new ProduktModel();
			produktTable.setTableModel(model);
			produktTable.init("Lista produktów");
			produktTable.setVisible(true);	
			
		}else if(e.getSource() == items[8]){
			
			SingleSession.getActualFrame().setTitle("Stan Magazynowy - Przychody");
			
		}else if(e.getSource() == items[9]){
			
			SingleSession.getActualFrame().setTitle("Stan Magazynowy - Rozchody");
			
		}else if(e.getSource() == items[10]){
			TableFrame magazynTable = new MagazynFrame();
			GenericModel model = new MagazynModel();
			magazynTable.setTableModel(model);
			magazynTable.init("Lista magazynów");
			magazynTable.setVisible(true);	
		}
	}
	
	


	
}