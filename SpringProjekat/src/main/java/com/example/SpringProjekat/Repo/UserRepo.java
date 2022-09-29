package com.example.SpringProjekat.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProjekat.Model.User;

public interface UserRepo extends JpaRepository<User, String> {

}
