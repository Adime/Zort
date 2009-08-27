package br.com.zort.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Teleport implements Serializable {

	private static final long serialVersionUID = 3055577618304863032L;

	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	@JoinColumn(name = "tile_id")
	private MapTile tile;

	private Integer mapFrom;
	private Integer mapTo;

	public Integer getMapFrom() {
		return mapFrom;
	}

	public void setMapFrom(Integer mapFrom) {
		this.mapFrom = mapFrom;
	}

	public Integer getMapTo() {
		return mapTo;
	}

	public void setMapTo(Integer mapTo) {
		this.mapTo = mapTo;
	}

	public MapTile getTile() {
		return tile;
	}

	public void setTile(MapTile tile) {
		this.tile = tile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id != 0)
			this.id = id;
	}

}
