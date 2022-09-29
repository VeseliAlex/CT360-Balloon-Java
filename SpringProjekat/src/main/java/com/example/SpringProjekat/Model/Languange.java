package com.example.SpringProjekat.Model;

import javax.persistence.*;

@Entity
@Table(name = "languanges")
public class Languange {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int idJezika;
	
	@Column(name = "name",nullable = false)
	private String imeJezika;
	
	@Column(name = "value",nullable = false)
	private String vrednost;

	public Languange() {
		
	}
	
	public Languange(int idJezika, String imeJezika, String vrednost) {
		this.idJezika = idJezika;
		this.imeJezika = imeJezika;
		this.vrednost = vrednost;
	}

	public int getIdJezika() {
		return idJezika;
	}

	public void setIdJezika(int idJezika) {
		this.idJezika = idJezika;
	}

	public String getImeJezika() {
		return imeJezika;
	}

	public void setImeJezika(String imeJezika) {
		this.imeJezika = imeJezika;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	
	
	
}
