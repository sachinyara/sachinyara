/**
 * 
 */
package demo.app.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demo.app.model.Address;
import demo.app.model.User;

/**
 * @author SKumar6
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tile");
		EntityManager em = factory.createEntityManager();
		User user = new User();
		user.setUserName("sachinyara");
		user.setFirstName("Sachin");
		user.setLastName("Kumar");
		Address address = new Address();
		address.setStreet("Thubarahalli, Varthur Main Road");
		address.setZipCode(560066L);
		address.setCity("Bengaluru");
		user.setAddress(address);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		System.out.println("sachinyara has been persisted...");
		em.close();
		factory.close();
	}

}
