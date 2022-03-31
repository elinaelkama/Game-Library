package swd22.GameLibrary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	//name?
	private String title;
	private int year;
	private int age;
	
	//attribute lisää
	//private Attribute;
	
	public Game(String title, int year, int age) {
		super();
		this.title = title;
		this.year = year;
		this.age = age;
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
	
	@Override
	public String toString() {
		return "id=" + id + ", title=" + title + ", year=" + year;
	}		
}
