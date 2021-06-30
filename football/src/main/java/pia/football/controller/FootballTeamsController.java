package pia.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pia.football.model.FootballTeam;
import pia.football.service.abstracts.FootballTeamInterface;

@RestController
@RequestMapping("/footballteams")
public class FootballTeamsController {

	private FootballTeamInterface footballTeamInterface;
	
	@Autowired
	public FootballTeamsController(FootballTeamInterface footballTeamInterface) {
		super();
		this.footballTeamInterface = footballTeamInterface;
	}
	
	@GetMapping("/getall")
	public List<FootballTeam> getAll(){
		return this.footballTeamInterface.getAll();
	}
	
	@GetMapping("delete")
	public void delete(int id) {
		this.footballTeamInterface.delete(id);
	}
	
	@PostMapping("update")
	public void update(@RequestBody FootballTeam footballTeam) {
		this.footballTeamInterface.update(footballTeam);
	}
	
	@PostMapping("add")
	public void add(@RequestBody FootballTeam footballTeam) {
		this.footballTeamInterface.add(footballTeam);
	}

}
