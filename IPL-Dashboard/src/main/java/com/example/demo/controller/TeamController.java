package com.example.demo.controller;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Team;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.TeamRepository;

@RestController
public class TeamController {
	
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;
	
	



	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		super();
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}





	@GetMapping("/team/{teamName}")
	public Team getTeam (@PathVariable String teamName) {
		
		Team team = this.teamRepository.findByTeamName(teamName);	
		
		team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName, 4));
		
		
		return team;
		
	}

}
