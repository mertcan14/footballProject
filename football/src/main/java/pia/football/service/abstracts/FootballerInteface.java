package pia.football.service.abstracts;

import java.util.List;

import pia.football.model.Footballer;

public interface FootballerInteface {

	List<Footballer> getAll();
	List<Footballer> getByTeam(int teamId);
	void add(Footballer footballer);
	void delete(int id);
}
