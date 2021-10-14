package com.fashionstore.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionstore.domain.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//query sql search function get id & display id & feedback
	@Query("SELECT u FROM User u WHERE u.id LIKE ?1")
	public List<User> findAll(Long keyword);
	
	
	//JRE file take a JPA REPOSITORY , its take to user entity  & primary key. Automatically generate

	
}
