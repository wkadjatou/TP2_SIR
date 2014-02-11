package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class ElectroniqueDevice {
	private int consommation;
	private long id;
	private Person person;
	private List<Heater> chauffage;
	
	public ElectroniqueDevice(){
		
	}
	public ElectroniqueDevice(int consommation){
		this.consommation=consommation;
		chauffage = new ArrayList<Heater>();
	}
	public int getConsommation() {
		return consommation;
	}
	public void setConsommation(int consommation) {
		this.consommation = consommation;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
@OneToMany
	public List<Heater> getChauffage() {
		return chauffage;
	}
	public void setChauffage(List<Heater> chauffage) {
		this.chauffage = chauffage;
	}
	

}
