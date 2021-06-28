package com.pack.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.MyUsers;
import com.pack.repo.MyRepo;

@Service
public class MyService {
@Autowired
	private MyRepo repo;

public void saveUser(MyUsers user) {
	repo.save(user);
	
}

public MyUsers findById(String email) {
	MyUsers user=repo.findById(email).get();
	return user;
}

public List<MyUsers> findAllUsers() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

public List<MyUsers> findOnlyUsers() {
	// TODO Auto-generated method stub
	return repo.findAllUsersOnly("user");
}

public List<MyUsers> findAllAdminUsers() {
	// TODO Auto-generated method stub
	return repo.findAllUsersAndAdmin();
}
@PostConstruct
public void addDefaultData() {
	List<MyUsers> def=new ArrayList<>();
	def.add(new MyUsers("user@gmail.com", "Param", "india@123", "user", "7047273554"));
	def.add(new MyUsers("admin@gmail.com", "V.Reddy", "india@123", "admin", "7047273554"));
	def.add(new MyUsers("super@gmail.com", "Vrushali", "india@123", "super user", "7047273554"));
repo.saveAll(def);
}
}
