package com.thinkingstack.swaggyplus.UtilityFunctions;

import java.util.Comparator;

import com.thinkingstack.swaggyplus.Resources.Dish;

import org.springframework.stereotype.Service;
@Service
public class SortDish implements Comparator<Dish> {
    public int compare(Dish a, Dish b) 
    { 
        return (int) (a.getDishId() - b.getDishId());
    }
}