package pia.football.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pia.football.model.Footballer;

public interface FootballerRepository extends JpaRepository<Footballer, Integer>{

	List<Footballer> getByFootballTeam_Id(int teamId);
	void deleteById(int id);
	
	@Query("SELECT COUNT(f) FROM Footballer f where f.footballTeam.id=:teamId")
	Integer countByTeam(int teamId);
	
	@Query("SELECT COUNT(f) FROM Footballer f where f.footballTeam.id=:teamId AND f.position.id=:positionId")
	Integer countByTeamAndPosition(int teamId, int positionId);
	
	@Query("SELECT COUNT(f) FROM Footballer f where f.footballTeam.id=:teamId AND f.isLocal=false")
	Integer countByTeamAndLocal(int teamId);
}
