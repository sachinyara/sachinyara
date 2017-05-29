package demo.bootapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Tile {
	@Id
	private Long id; 
	@Column(name="default_tile")
	private boolean defaultTile; 
	@Column(name="tile_number")
	private Long tileNumber; 
	@Column(name="pagelayout_id")
	private Long pagelayoutId; 
	@Column(name="moduletype_id")
	private Long moduletypeId;
	@Transient
	private String desc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isDefaultTile() {
		return defaultTile;
	}
	public void setDefaultTile(boolean defaultTile) {
		this.defaultTile = defaultTile;
	}
	public Long getTileNumber() {
		return tileNumber;
	}
	public void setTileNumber(Long tileNumber) {
		this.tileNumber = tileNumber;
	}
	public Long getPagelayoutId() {
		return pagelayoutId;
	}
	public void setPagelayoutId(Long pagelayoutId) {
		this.pagelayoutId = pagelayoutId;
	}
	public Long getModuletypeId() {
		return moduletypeId;
	}
	public void setModuletypeId(Long moduletypeId) {
		this.moduletypeId = moduletypeId;
	}
}
