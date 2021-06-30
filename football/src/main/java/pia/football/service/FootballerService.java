package pia.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pia.football.model.Footballer;
import pia.football.repository.FootballerRepository;
import pia.football.service.abstracts.FootballerInteface;

@Service
public class FootballerService implements FootballerInteface{

	private FootballerRepository footballerRepository;
	
	@Autowired
	public FootballerService(FootballerRepository footballerRepository) {
		super();
		this.footballerRepository = footballerRepository;
	}
	
	@Override
	public List<Footballer> getAll() {
		return this.footballerRepository.findAll();
	}

	@Override
	public List<Footballer> getByTeam(int teamId) {
		return this.footballerRepository.getByFootballTeam_Id(teamId);
	}

	@Override
	public void add(Footballer footballer) {
		if (countByTeam(footballer.getFootballTeam().getId()) == false) {
			System.out.println("18den fazla");
		}
		else if (countByTeamAndPosition(footballer.getFootballTeam().getId(), footballer.getPosition().getId()) == false) {
			System.out.println("2den fazla");
		}
		else if (countByTeamAndLocal(footballer.getFootballTeam().getId(), footballer.getIsLocal()) == false) {
			System.out.println("6den fazla");
		}
		else {
			this.footballerRepository.save(footballer);
		}
		
	}

	@Override
	public void delete(int id) {
		this.footballerRepository.deleteById(id);
	}

	private boolean countByTeam(int teamId) {
		if (this.footballerRepository.countByTeam(teamId)>=18) {
			return false;
		}
		return true;
	}
	
	private boolean countByTeamAndPosition(int teamId, int positionId) {
		if (this.footballerRepository.countByTeamAndPosition(teamId, positionId)>=2 && positionId==1) {
			return false;
		}
		return true;
	}
	
	private boolean countByTeamAndLocal(int teamId, boolean isLocal) {
		if (this.footballerRepository.countByTeamAndLocal(teamId)>=6 && isLocal==false) {
			return false;
		}
		return true;
	}
}
