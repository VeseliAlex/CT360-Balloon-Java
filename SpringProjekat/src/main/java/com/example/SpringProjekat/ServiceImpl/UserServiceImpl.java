package com.example.SpringProjekat.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProjekat.Model.User;
import com.example.SpringProjekat.Repo.UserRepo;
import com.example.SpringProjekat.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	
	@Override
	public List<User> nadjiSveKorisnike() {
		return userRepo.findAll();
	}

	@Override
	public User nadjiJednogKorisnika(String korisnickoIme) {
		return userRepo.findById(korisnickoIme).orElseGet(null);
	}

}
