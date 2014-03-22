package fr.istic.tpjpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.ElectroniqueDevice;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.PeripherieInt;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// TODO create entity
		PeripherieInt p = new PeripherieInt();
		
		Person person = new Person("balde", "kadiatou","balde.kadjatou@gmail.com" , "kadjatou");
		Person person1 = new Person("balde", "kadiatou","balde.kadjatou@gmail.com" , "kadjatou");
		Person person2 = new Person("balde", "kadiatou","balde.kadjatou@gmail.com" , "kadjatou");
		Home home = new Home(24, 1, "djsgfhjsdhfgdsq", "128.01.123");
		Heater chauffage = new Heater(20);
		ElectroniqueDevice device = new ElectroniqueDevice(30);
	
		person.getFriends().add(person1);
		person.getFriends().add(person2);
		person.getDevices().add(device);
		person.getHomes().add(home);
		
		home.getChauffage().add(chauffage);
		
		device.setPerson(person);
		chauffage.setHome(home);
		home.setPerson(person); 
		
		
		manager.persist(person);
		manager.persist(person1);
		manager.persist(person2);
		manager.persist(device);
		
		
//		PeripherieIntelligent peripherie = new PeripherieIntelligent("equipement", 4);
//		
//		chauffage.setNomP("chauffage collectif");
//		chauffage.setNomP("Chauffage Electrique");
//		device.setNomP("device 1");
//		device.setNomP("device 2");
//		
//		manager.persist(peripherie);
//		
		

		// TODO persist entity

		tx.commit();

		// TODO run request

		System.out.println(".. done");
		
	}

}
