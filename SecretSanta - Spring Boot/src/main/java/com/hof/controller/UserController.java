package com.hof.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hof.domain.Feedback;
import com.hof.domain.Rating;
import com.hof.domain.Role;
import com.hof.domain.User;
import com.hof.domain.dto.FeedBackRating;
import com.hof.domain.dto.ProductDto;
import com.hof.services.CartService;
import com.hof.services.UserService;



@RestController
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@Autowired 
	CartService cartService;
	
	
	@PostMapping("/user")
	public User getSupplierData(@Valid @RequestBody User u) {
		System.out.println(u.getEmailAddress() + u.getPassword());
		String email = u.getEmailAddress();
		String pass = u.getPassword();
		User s = uservice.validate(email, pass);
		return s;
	}
	
	@PostMapping("/UserReg")
	public User getUserDataReg(@RequestBody User u)
	{
		
		Role role=new Role();
		role.setRoleName("user");
		role.setRoleId(1);
		u.setRole(role);
		System.out.println("firstName: " + u.toString());
		User user=uservice.userReg(u); 
		 
		return user;	
	}
	@PostMapping("/feedback")
	public String getFeedback(@RequestBody FeedBackRating fr) {
		
		System.out.println("fr == "+fr.toString());
		Integer userid = Integer.parseInt(fr.getName());
		System.out.println("integer : "+ userid);
		User user = cartService.getUserData(userid);
		
		Feedback f = new Feedback();
		
		f.setEmailId(user.getEmailAddress());
		f.setName(user.getFirstName());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		f.setCreatedDate(date);
		
		uservice.addFeedBack(f);
		
		Rating rating= new Rating();

		if(fr.getRatingId()==1 )
		{
			System.out.println("in if loop");
			rating.setRatingId(1);
			rating.setRatingName("Bad");
		}
		if(fr.getRatingId()==2 )
		{
			rating.setRatingId(2);
			rating.setRatingName("Average");
		}
		if(fr.getRatingId()==3 )
		{
			rating.setRatingId(3);
			rating.setRatingName("Good");
		}
		if(fr.getRatingId()==4 )
		{
			rating.setRatingId(4);
			rating.setRatingName("Very good");
		}
		if(fr.getRatingId()==5 )
		{
			rating.setRatingId(5);
			rating.setRatingName("Excellent");
		}
		
		
		
		System.out.println("rating === "+ rating.toString());
		
		f.setRating(rating);
		
		System.out.println("feedback: ==== " + f.toString());
		uservice.addFeedBack(f); 
	
		
		
		
		return "successfull";
	
	}
}
