package com.thinkingstack.swaggyplus.Resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dish {
	@Id
	@GeneratedValue
	private Long dishId;
	private String dishName;
	private String shortDescription;
	private String imageUrl;
	private Boolean isVeg;
	private Boolean freeDelivery;
	private Double price;
	public Dish(Long dishId, String dishName, String shortDescription, String imageUrl, Boolean isVeg,
			Boolean freeDelivery, Double price) {
		
		this.dishId = dishId;
		this.dishName = dishName;
		this.shortDescription = shortDescription;
		this.imageUrl = imageUrl;
		this.isVeg = isVeg;
		this.freeDelivery = freeDelivery;
		this.price = price;
	}
	public Dish() {
		
	}
	public Long getDishId() {
		return dishId;
	}
	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Boolean getIsVeg() {
		return isVeg;
	}
	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}
	public Boolean getFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(Boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", shortDescription=" + shortDescription
				+ ", imageUrl=" + imageUrl + ", isVeg=" + isVeg + ", freeDelivery=" + freeDelivery + ", price=" + price
				+ "]";
	}
}
