package swd22.GameLibrary.domain;

import java.util.List;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String title;
	
	@NotNull
	private int year;
	
	@NotNull
	private int age;
	
	@ManyToOne
	@JsonIgnoreProperties
    @JoinColumn(name = "platformid")
	private Platform platform;
	
	@ManyToMany
	@JsonIgnoreProperties
	@JoinTable(
			name = "gameattributes", 
			joinColumns = @JoinColumn(name = "gameid"), 
			inverseJoinColumns = @JoinColumn(name = "attributeid"))
	private List<Attribute> attributes;
	
	public Game(String title, int year, int age, Platform platform) {
		super();
		this.title = title;
		this.year = year;
		this.age = age;
		this.platform = platform;
	}
	
	public Game(String title, int year, int age, Platform platform, List<Attribute> attributes) {
		super();
		this.title = title;
		this.year = year;
		this.age = age;
		this.platform = platform;
		this.attributes = attributes;
	}
	
	public Game() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}
	
	public boolean hasAttribute(Attribute attribute) {
		return attributes.contains(attribute);
	}
	
	public void deleteAttribute(Attribute attribute) {
		attributes.remove(attribute);
	}

	@Override
	public String toString() {
		return "id=" + id + ", title=" + title + ", year=" + year + ", age=" + age +", platform=" + platform + ", attributes=" + attributes;
	}		
}
