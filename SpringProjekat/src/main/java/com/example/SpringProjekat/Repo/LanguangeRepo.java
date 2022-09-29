package com.example.SpringProjekat.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SpringProjekat.Model.Languange;

public interface LanguangeRepo extends JpaRepository<Languange, Integer>{
	
	@Query(value="select * from jezici where ime_jezika= ?1", nativeQuery = true)
	Languange nadjiJezikPrekoImena(String imeJezika);

}
