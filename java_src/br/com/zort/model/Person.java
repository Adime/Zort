package br.com.zort.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = -698172690674134816L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Boolean sex;
	private String imageFront;
	private String imageBack;
	private String imageRight;
	private String imageLeft;
	
	
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
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getImageFront() {
		return imageFront;
	}
	public void setImageFront(String imageFront) {
		this.imageFront = imageFront;
	}
	public String getImageBack() {
		return imageBack;
	}
	public void setImageBack(String imageBack) {
		this.imageBack = imageBack;
	}
	public String getImageRight() {
		return imageRight;
	}
	public void setImageRight(String imageRight) {
		this.imageRight = imageRight;
	}
	public String getImageLeft() {
		return imageLeft;
	}
	public void setImageLeft(String imageLeft) {
		this.imageLeft = imageLeft;
	}
	
	
	
}
