package br.com.zort.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MapTile implements Serializable {

	private static final long serialVersionUID = -8822346702532819628L;

	@Id
	@GeneratedValue
	private Integer id;
	private Integer x;
	private Integer y;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "map_id")
	private Map map;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "tile_id")
	private Tile tile;

	@OneToOne(mappedBy = "tile", cascade = {CascadeType.ALL})
	private Teleport teleport;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Teleport getTeleport() {
		return teleport;
	}

	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id != 0)
			this.id = id;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

}
