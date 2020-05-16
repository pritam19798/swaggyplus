package com.thinkingstack.swaggyplus.Repository;

import com.thinkingstack.swaggyplus.Resources.Cart;
import com.thinkingstack.swaggyplus.Resources.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
    public Cart  findByUser(User user);
}