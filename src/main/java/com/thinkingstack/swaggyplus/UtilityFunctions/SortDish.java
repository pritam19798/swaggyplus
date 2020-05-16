package com.thinkingstack.swaggyplus.UtilityFunctions;

import java.util.Comparator;

import com.thinkingstack.swaggyplus.Resources.Dish;

public class SortDish implements Comparator<Dish> {
    public int compare(Dish a, Dish b) 
    { 
        return (int) (a.getDishId() - b.getDishId());
    }
}