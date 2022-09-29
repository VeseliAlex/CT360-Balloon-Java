package com.example.SpringProjekat.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProjekat.Model.Languange;
import com.example.SpringProjekat.Repo.LanguangeRepo;
import com.example.SpringProjekat.Service.LanguangeService;

@Service
public class LanguangeServiceImpl implements LanguangeService {
	
	@Autowired
	LanguangeRepo languangeRepo;

	@Override
	public List<Languange> nadjiSveJezike() {
		return languangeRepo.findAll();
	}

	@Override
	public Languange nadjiJedanJezikPrekoImena(String jezik) {
		return languangeRepo.nadjiJezikPrekoImena(jezik);
	}

	@Override
	public void sacuvajJezik(Languange noviLanguange) {
		languangeRepo.save(noviLanguange);
		
	}

}
