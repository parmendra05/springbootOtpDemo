package com.pack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.entity.MyUsers;
@Repository
public interface MyRepo extends JpaRepository<MyUsers, String> {
	@Query(" FROM MyUsers  WHERE role =:user")
	List<MyUsers> findAllUsersOnly(@Param("user") String user);
	
	//@Query(" FROM MyUsers  WHERE role =:user AND role=:admin" )
	//List<MyUsers> findAllUsersAndAdmin(@Param("user") String user,@Param("admin") String admin);
	
	@Query(value =  "select * from  my_users where role in ('user' ,'admin')" , nativeQuery = true )
	List<MyUsers> findAllUsersAndAdmin();

}
