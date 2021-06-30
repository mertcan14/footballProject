package pia.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pia.football.model.FootballTeam;
import pia.football.repository.FootballTeamRepository;
import pia.football.service.abstracts.FootballTeamInterface;

@Service
public class FootballTeamService implements FootballTeamInterface{

	@Autowired FootballTeamRepository footballTeamRepository;
	
	@Override
	public List<FootballTeam> getAll() {
		return footballTeamRepository.findAll();
	}

	@Override
	public void delete(int id) {
		footballTeamRepository.deleteById(id);
	}

	@Override
	public void update(FootballTeam footballTeam) {
		footballTeamRepository.save(footballTeam);
	}

	@Override
	public void add(FootballTeam footballTeam) {
		footballTeamRepository.save(footballTeam);
	}
	

}
