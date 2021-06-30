package pia.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pia.football.model.Footballer;
import pia.football.service.abstracts.FootballerInteface;

@RestController
@RequestMapping("/footballers")
public class FootballersController {
	private FootballerInteface footballerInteface;
	
	@Autowired
	public FootballersController(FootballerInteface footballerInteface) {
		super();
		this.footballerInteface = footballerInteface;
	}
	
	@GetMapping("/getall")
	public List<Footballer> getAll(){
		return this.footballerInteface.getAll();
	}
	
	@GetMapping("/delete")
	public void delete(int id){
		this.footballerInteface.delete(id);
	}
	
	@GetMapping("/getbyteam")
	public List<Footballer> getByTeam(int teamId){
		return this.footballerInteface.getByTeam(teamId);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Footballer footballer) {
		this.footballerInteface.add(footballer);
	}
	

}
