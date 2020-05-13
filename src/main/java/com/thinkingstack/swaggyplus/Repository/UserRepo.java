package com.thinkingstack.swaggyplus.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkingstack.swaggyplus.Resources.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
}
