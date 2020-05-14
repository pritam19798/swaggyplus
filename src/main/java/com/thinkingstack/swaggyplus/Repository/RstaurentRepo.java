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

}
