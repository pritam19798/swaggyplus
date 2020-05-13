package com.thinkingstack.swaggyplus.Resources;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Restaurent {
	@Id
	@GeneratedValue
	private Long restaurentId;
	private String restaurentName;
	private Boolean isActive;
	private String restaurentAdress;
	private int restaurentRating;

	
	public Restaurent(Long restaurentId, String restaurentName, Boolean isActive, String restaurentAdress,
			int restaurentRating) {
		this.restaurentId = restaurentId;
		this.restaurentName = restaurentName;
		this.isActive = isActive;
		this.restaurentAdress = restaurentAdress;
		this.restaurentRating = restaurentRating;

	}


	public Long getRestaurentId() {
		return restaurentId;
	}


	public void setRestaurentId(Long restaurentId) {
		this.restaurentId = restaurentId;
	}


	public String getRestaurentName() {
		return restaurentName;
	}


	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public String getRestaurentAdress() {
		return restaurentAdress;
	}


	public void setRestaurentAdress(String restaurentAdress) {
		this.restaurentAdress = restaurentAdress;
	}


	public int getRestaurentRating() {
		return restaurentRating;
	}


	public void setRestaurentRating(int restaurentRating) {
		this.restaurentRating = restaurentRating;
	}





	public Restaurent() {
		
	}
}
