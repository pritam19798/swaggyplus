package com.thinkingstack.swaggyplus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkingstack.swaggyplus.Resources.Dish;


public interface DishRepo extends JpaRepository<Dish ,Long> {
	public List<Dish> findBydishName(String dishName);

}
