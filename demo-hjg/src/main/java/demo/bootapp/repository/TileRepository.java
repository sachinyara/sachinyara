package demo.bootapp.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.bootapp.model.Tile;

@Repository
public class TileRepository {
	@Autowired
	private EntityManager em;
		
	public List<Tile> getTiles(){
		em.getTransaction().begin();
		List<Tile> tiles = em.createQuery("select t from Tile t where t.id=:id", Tile.class).setParameter("id", new Long(154)).getResultList();
		em.getTransaction().commit();
		return tiles;
	}
}
