package com.pack.service;

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
}
