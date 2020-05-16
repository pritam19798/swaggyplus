package com.thinkingstack.swaggyplus.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.thinkingstack.swaggyplus.Repository.CartRepo;
import com.thinkingstack.swaggyplus.Repository.DishRepo;
import com.thinkingstack.swaggyplus.Repository.UserRepo;
import com.thinkingstack.swaggyplus.Resources.Cart;
import com.thinkingstack.swaggyplus.Resources.Dish;
import com.thinkingstack.swaggyplus.Resources.User;
import com.thinkingstack.swaggyplus.UtilityFunctions.SortDish;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private DishRepo dishRepo;

	@Autowired
	private CartRepo cartrepo;



	public Double calculatePrice(List<Dish> dishes){
		double price=0;
		for(Dish dish:dishes){
			price=price+dish.getPrice();
		}
		System.out.println(price);
		return price;
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		User parsistUser=userRepo.saveAndFlush(user);
		Cart cart=new Cart();
		cart.setUser(user);
		List<Dish> d=new ArrayList<Dish>();
		cart.setdishes(d);
		cart.settotalAmount(this.calculatePrice(d));
		cartrepo.save(cart);
		return parsistUser;
	}

    
	@GetMapping("/getUserName")
	public ResponseEntity<String> getUserName(@RequestParam String Id){
		
	   User name=userRepo.findById(Long.parseLong(Id)).get();
	      return new ResponseEntity<>(name.getName(),HttpStatus.OK);
		
	}



	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody User user) {
		try{
			User byId=userRepo.findById(user.getUserId()).get();
			if(byId.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>((byId.getUserId()).toString() ,HttpStatus.OK);
			}else {
				return  new ResponseEntity<>("unauthorized",HttpStatus.UNAUTHORIZED);
			}
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
		}
	}



	//cart related API.....

	
	@PostMapping(value="/{userId}/cart/dish")
	public Cart addToCart(@PathVariable Long userId,@RequestParam Long dishId) {
		User user=userRepo.findById(userId).get();
		Dish dish=dishRepo.findById(dishId).get();
		Cart cart= cartrepo.findByUser(user);
		List<Dish> d=cart.getdishes();
		d.add(dish);
		Collections.sort(d, new SortDish());
		cart.setdishes(d);
		cart.settotalAmount(this.calculatePrice(d));
		cart=cartrepo.save(cart);
		
		System.out.println(cart);
		return cart;
	}

	@GetMapping(value="/{userId}/cart/dish")
	public List<Dish> showalldish(@PathVariable Long userId){

		User user=userRepo.findById(userId).get();
		Cart cart= cartrepo.findByUser(user);
		List<Dish> d=cart.getdishes();
		return d;
	
	}
	@DeleteMapping(value="/{userId}/cart/dish")
	public Cart deleteFromCart(@PathVariable Long userId,@RequestParam Long dishId){
		User user=userRepo.findById(userId).get();
		Dish dish=dishRepo.findById(dishId).get();
		Cart cart= cartrepo.findByUser(user);
		List<Dish> d=cart.getdishes();
		int index=d.indexOf(dish);
		d.remove(index);
		cart.setdishes(d);
		cart.settotalAmount(this.calculatePrice(d));
		return cartrepo.save(cart);
	}
	@GetMapping(value = "/{userId}/cart/price")
	public Double getprice(@PathVariable Long userId){
		User user=userRepo.findById(userId).get();
		Cart cart= cartrepo.findByUser(user);
		return cart.gettotalAmount();
	}



}
