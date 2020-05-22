package com.thinkingstack.swaggyplus.Resources;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Long cartId;

	@OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName="userId")
	private User user;

	@ManyToMany(targetEntity = Dish.class, cascade = CascadeType.ALL)
	private List<Dish> dishes;
	private Double totalAmount;


	@OneToOne(targetEntity=Restaurent.class,cascade=CascadeType.ALL)
	@JoinColumn(name="resId",referencedColumnName="restaurentId")
	private Restaurent restaurent;

	public Cart() {
		
	}

	public Cart(Long cartId, User user, Restaurent restaurent, List<Dish> dishes, Double totalAmount) {
		this.cartId = cartId;
		this.user = user;
		this.restaurent = restaurent;
		this.dishes = dishes;
		this.totalAmount = totalAmount;
	}




	public Restaurent getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	public Long getcartId() {
		return cartId;
	}
	public void setcartId(Long cartId) {
		this.cartId = cartId;
	}
	public List<Dish> getdishes() {
		return dishes;
	}
	public void setdishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	public Double gettotalAmount() {
		return totalAmount;
	}
	public void settotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", dishes=" + dishes + ", TotalAmount=" + totalAmount + "]";
	}




	
}