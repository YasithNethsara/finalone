package com.fashionstore.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fashionstore.domain.User;
import com.fashionstore.repository.UserRepository;


	

@Service
public class UserService {

	@Autowired
	private UserRepository Repo;
	
	//returns the user table as a list
	public List<User>listAll(Long keyword){
		if (keyword != null) {
			return Repo.findAll(keyword);
    	
		}
		return Repo.findAll();
	}
	
	public void save(User us) {
		Repo.save(us);
	}
	
	//returns the primary key of the record to the relevant id
	public User get(int id) {
		return Repo.findById((long) id).get();
	}
	public void delete(int id) {
		Repo.deleteById((long) id);
	}
	
	
	         
	       
	    }



