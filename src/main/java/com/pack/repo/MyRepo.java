package com.pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.MyUsers;
@Repository
public interface MyRepo extends JpaRepository<MyUsers, String> {

}
