package com.thinkingstack.swaggyplus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thinkingstack.swaggyplus.Resources.Dish;
import com.thinkingstack.swaggyplus.Resources.Restaurent;

public interface RstaurentRepo extends JpaRepository<Restaurent ,Long> {
	
	public List<Restaurent> findByrestaurentName(String restaurentName);
	
	@Query("SELECT R.dishes from Restaurent R WHERE R.restaurentId=:Id")
	public List<Dish> getDishes(@Param("Id") Long Id);

	public List<Restaurent> findByrestaurentNameContainingIgnoreCase(String restaurentName);

	public List<Restaurent> findByDishes_dishNameContainingIgnoreCase(String restaurentName);

	public Restaurent findByDishesContaining(Dish dish);

	public List<Restaurent> findByisActive(Boolean isActive);


}
