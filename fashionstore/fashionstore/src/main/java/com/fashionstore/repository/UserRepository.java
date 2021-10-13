package com.fashionstore.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionstore.domain.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.id LIKE ?1")
	public List<User> findAll(Long keyword);
	
	
	//JRE file take a JPAREPOSITORY , its take to user entity  & primary key. Automatically generate

	
}