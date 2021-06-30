package pia.football.service.abstracts;

import java.util.List;

import pia.football.model.FootballTeam;

public interface FootballTeamInterface {
	List<FootballTeam> getAll();
	void add(FootballTeam footballTeam);
	void delete(int id);
	void update(FootballTeam footballTeam);
}
