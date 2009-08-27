package br.com.zort.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tile implements Serializable {

	private static final long serialVersionUID = 5331714032719534856L;

	@Id
	@GeneratedValue
	private Integer id;
	private String source;
	private Boolean isWalkable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id != 0)
			this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getIsWalkable() {
		return isWalkable;
	}

	public void setIsWalkable(Boolean isWalkable) {
		this.isWalkable = isWalkable;
	}

}
