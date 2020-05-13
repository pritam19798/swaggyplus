package com.thinkingstack.swaggyplus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkingstack.swaggyplus.Resources.Restaurent;

public interface RstaurentRepo extends JpaRepository<Restaurent ,Long> {
	
	public List<Restaurent> findByrestaurentName(String restaurentName);

}
