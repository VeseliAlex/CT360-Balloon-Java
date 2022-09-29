package com.example.SpringProjekat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @Column(name = "username",unique = true,nullable = false)
    private String korisnicko_ime;
	
	
	@Column(name = "password",nullable = false)
	private String lozinka;
	
	
	@Column(name = "role",nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Role role;

	
	
	public User(String korisnickoIme, String lozinka, Role role) {
		this.korisnicko_ime = korisnickoIme;
		this.lozinka = lozinka;
		this.role = role;
	}


	public String getKorisnickoIme() {
		return korisnicko_ime;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnicko_ime = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	public Role getUloga() {
		return role;
	}


	public void setUloga(Role role) {
		this.role = role;
	}
	
	
	

}
