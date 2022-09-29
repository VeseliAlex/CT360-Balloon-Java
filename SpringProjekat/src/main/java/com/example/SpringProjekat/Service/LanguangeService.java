package com.example.SpringProjekat.Service;

import java.util.List;

import com.example.SpringProjekat.Model.Languange;

public interface LanguangeService {
	
	List<Languange> nadjiSveJezike();
	Languange nadjiJedanJezikPrekoImena(String jezik);
	void sacuvajJezik(Languange noviLanguange);

}
