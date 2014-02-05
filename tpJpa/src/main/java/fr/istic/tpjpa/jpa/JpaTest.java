package fr.istic.tpjpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.ElectroniqueDevice;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
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
		Person person = new Person("balde", "kadiatou","balde.kadjatou@gmail.com" , "kadjatou");
		Person person1 = new Person("balde", "kadiatou","balde.kadjatou@gmail.com" , "kadjatou");
		Person person2 = new Person("balde", "kadiatou","balde.kadjatou@gmail.com" , "kadjatou");
		Home home = new Home(24, 1, "djsgfhjsdhfgdsq", "128.01.123");
		Heater chauffage = new Heater(20);
		ElectroniqueDevice device = new ElectroniqueDevice(20);
	
		person.getFriends().add(person1);
		person.getFriends().add(person2);
		person.getDevices().add(device);
		
		home.getChauffage().add(chauffage);
		
		device.setPerson(person);
		person.getHomes().add(home);
		chauffage.setHome(home);
		home.setPerson(person); 
		manager.persist(person);
		manager.persist(person1);
		manager.persist(person2);
		manager.persist(device);
		

		// TODO persist entity

		tx.commit();

		// TODO run request

		System.out.println(".. done");
		
	}

}
