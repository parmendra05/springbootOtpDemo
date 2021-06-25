package com.pack.service;

import java.util.List;

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
}
