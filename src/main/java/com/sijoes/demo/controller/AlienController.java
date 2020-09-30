package com.sijoes.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.sijoes.demo.dao.AlienRepo;
import com.sijoes.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	@DeleteMapping("/alien/{aid}")
	public Alien deleteAlien(@PathVariable int aid) {
		Alien al = repo.findById(aid).orElse(null);
		repo.delete(al);
		return al;
	}
	@GetMapping(path="/aliens")
	@ResponseBody
	public Iterable<Alien> getAliens() {
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(null);
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTech("Java"));
//		System.out.println(repo.findByTechSorted("Java"));
//		mv.addObject(alien);
		return repo.findAll();
	}
	@PutMapping("/alien")
	public Alien updateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	@RequestMapping("/alien/{aid}")	
	public Optional<Alien> getAlien(@PathVariable int aid) {
		return repo.findById(aid);
	
	}
}
