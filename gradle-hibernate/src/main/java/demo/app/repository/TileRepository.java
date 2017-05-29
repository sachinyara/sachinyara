package demo.app.repository;

import java.util.List;

import javax.persistence.EntityManager;

import demo.app.model.Tile;

public class TileRepository {
	
	private EntityManager em;
	public TileRepository(EntityManager em) {
		this.em=em;
	}	
	public List<Tile> getTiles(){
		em.getTransaction().begin();
		List<Tile> tiles = em.createQuery("select t from Tile t where t.id=:id", Tile.class).setParameter("id", new Long(154)).getResultList();
		em.getTransaction().commit();
		return tiles;
	}
}
