package pl.projektDB.beans;

import javax.persistence.*;

@Entity
public class Rabat{
	
	@Id
	@GeneratedValue
	private int rabat_id;
	private double wysokosc;
	
	public int getRabat_id() {
		return rabat_id;
	}
	public void setRabat_id(int rabat_id) {
		this.rabat_id = rabat_id;
	}
	public double getWysokosc() {
		return wysokosc;
	}
	public void setWysokosc(double wysokosc) {
		this.wysokosc = wysokosc;
	}	
	
	public String toString() {
		return wysokosc+"";
	}
	
}