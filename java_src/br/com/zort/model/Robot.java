package br.com.zort.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Robot {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer hp;
	private Integer level;
	private Integer experience;
	
	private String nome;
	private String image;
	
	@OneToOne
	private Item head;
	@OneToOne
	private Item body;
	@OneToOne
	private Item leftHand;
	@OneToOne
	private Item rightHand;
	@OneToOne
	private Item legs;
	@OneToOne
	private Item feet;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="robot")
	private List<Skill> skills;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id != 0)
			this.id = id;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Item getHead() {
		return head;
	}

	public void setHead(Item head) {
		this.head = head;
	}

	public Item getBody() {
		return body;
	}

	public void setBody(Item body) {
		this.body = body;
	}

	public Item getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(Item leftHand) {
		this.leftHand = leftHand;
	}

	public Item getRightHand() {
		return rightHand;
	}

	public void setRightHand(Item rightHand) {
		this.rightHand = rightHand;
	}

	public Item getLegs() {
		return legs;
	}

	public void setLegs(Item legs) {
		this.legs = legs;
	}

	public Item getFeet() {
		return feet;
	}

	public void setFeet(Item feet) {
		this.feet = feet;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
