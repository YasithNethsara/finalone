package com.fashionstore.domain;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


   
	@Entity
	public class User {
		
		@Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name="u_id")
	    private Long id;
		
	    private String feedback;

	    private String helpfull;
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(Long id, String feedback, String helpfull) {
			super();
			this.id = id;
			this.feedback = feedback;
			this.helpfull = helpfull;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		public String getHelpfull() {
			return helpfull;
		}
		public void setHelpfull(String helpfull) {
			this.helpfull = helpfull;
		}
	 	
	
}
