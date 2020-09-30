package com.sijoes.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.sijoes.demo.model.Alien;



public interface AlienRepo extends  CrudRepository<Alien, Integer>{

//	List<Alien> findByAidGreaterThan(int aid);
//	List<Alien> findByTech(String tech);
//	@Query("from Alien where tech=?1 order by aname")
//	List<Alien> findByTechSorted(String tech);
	
}
