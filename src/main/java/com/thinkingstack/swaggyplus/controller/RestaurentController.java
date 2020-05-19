package com.thinkingstack.swaggyplus.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkingstack.swaggyplus.Resources.Dish;
import com.thinkingstack.swaggyplus.Resources.Restaurent;

import com.thinkingstack.swaggyplus.Repository.DishRepo;
import com.thinkingstack.swaggyplus.Repository.RstaurentRepo;

@RestController
@RequestMapping("/res")
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurentController {
	
	@Autowired
	private RstaurentRepo restorentRepo;
	@Autowired
	private DishRepo dishRepo;
	
	//admin area.....

	@PostMapping("/addrestaurent")
	public Restaurent addRestaurent(@RequestBody Restaurent restaurent) {
		return restorentRepo.saveAndFlush(restaurent);
	}

	@PutMapping("/restaurent")
	public ResponseEntity<Restaurent> editRestaurent(@RequestParam Long id, @RequestBody Restaurent restaurent){
		Restaurent updatedRestaurent=restorentRepo.save(restaurent);
		return new ResponseEntity<Restaurent>(updatedRestaurent,HttpStatus.OK);
	}

	@PutMapping("addDish/{id}")
	public ResponseEntity<Restaurent> addDish(@PathVariable Long id,@RequestBody Dish dish){
		try {
			Restaurent r=restorentRepo.findById(id).get();
			List<Dish> d=r.getDishes();
			d.add(dish);
			r.setDishes(d);
			System.out.println(r);
			return new ResponseEntity<Restaurent>(restorentRepo.save(r),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Restaurent>( HttpStatus.NOT_FOUND);
		}	
	}

	@PutMapping("editDish")
	public ResponseEntity<Dish> editDish(@RequestParam Long id, @RequestBody Dish dish){
		Dish updatedDish=dishRepo.save(dish);
		return new ResponseEntity<Dish>(updatedDish,HttpStatus.OK);
	}




	//user Area.....


	@GetMapping("/getrestaurent")
	public List<Restaurent> getRestaurent() {
		return restorentRepo.findAll();
	}

	@GetMapping("/restaurent")
	public ResponseEntity<Restaurent> getRestaurentById(@RequestParam Long id) {
		try{
			return new ResponseEntity<Restaurent>(restorentRepo.findById(id).get(), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Restaurent>( HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping("/restaurentNmae")
	public ResponseEntity<List<Restaurent>> getRestaurentByName(@RequestParam String name) {
		try{
			System.out.println("aaa");
			//return new ResponseEntity<List<Restaurent>>(restorentRepo.findByrestaurentName(name),HttpStatus.OK);
			return new ResponseEntity<List<Restaurent>>(restorentRepo.findByrestaurentNameContainingIgnoreCase(name),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<List<Restaurent>>( HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping("/dish")
	public ResponseEntity<Dish> getDishById(@RequestParam Long id) {
		try{
			return new ResponseEntity<Dish>(dishRepo.findById(id).get(), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Dish>( HttpStatus.NOT_FOUND);
		}
	}
	


	@GetMapping("/dishName")
	public ResponseEntity<List<Restaurent>> getDishByName(@RequestParam String name) {
		try{
			System.out.println("aaa");
			return new ResponseEntity<List<Restaurent>>(restorentRepo.findByDishes_dishNameContainingIgnoreCase(name),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<List<Restaurent>>( HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping("/dishes")
	public List<Dish> getDish(@RequestParam Long id){
		return restorentRepo.getDishes(id);
		
	}
	


	
	
}


