package br.com.zort.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Map implements Serializable {
	
	private static final long serialVersionUID = -7876205902802836439L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "map",cascade={CascadeType.ALL})
	private List<MapTile> tiles;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if (id != 0)
			this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MapTile> getTiles() {
		return tiles;
	}
	public void setTiles(List<MapTile> tiles) {
		this.tiles = tiles;
	}
	
	

}
