package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater {

	private int consomation;
	private long id;
	private Home home;
	
	public Heater(){
		
	}
	public Heater(int consomation){
		this.consomation=consomation;
	}
	public int getConsomation() {
		return consomation;
	}
	public void setConsomation(int consomation) {
		this.consomation = consomation;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	
	
}
