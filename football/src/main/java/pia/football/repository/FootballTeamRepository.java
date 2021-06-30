package pia.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pia.football.model.FootballTeam;

public interface FootballTeamRepository extends JpaRepository<FootballTeam, Integer>{
	void deleteById(int id);
}
