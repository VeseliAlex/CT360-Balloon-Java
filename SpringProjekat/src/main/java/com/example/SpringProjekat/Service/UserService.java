package com.example.SpringProjekat.Service;

import java.util.List;

import com.example.SpringProjekat.Model.User;

public interface UserService {
	
	List<User> nadjiSveKorisnike();
	User nadjiJednogKorisnika(String korisnickoIme);

}
