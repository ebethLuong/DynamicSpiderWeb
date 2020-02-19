package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "petSpiders")
public class SpiderModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	@Column(name="SPECIES")
	private String species;
	
	

	public SpiderModel ()
	{
		
	}

	public SpiderModel(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String returnSpiderDetails()
	{
		return id + ") " + name + ", " + species;
	}
	
	

}