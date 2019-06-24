package com.example.PracticaParcial.service;

import com.example.PracticaParcial.interfaces.TotalPlayersByTeamsName;
import com.example.PracticaParcial.models.Team;
import com.example.PracticaParcial.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TeamService {
    @Autowired
    private TeamRepository TeamRepository;

    public void addTeam(Team Team){
        TeamRepository.save(Team);
    }

    public List<Team> getTeams(){

        return  TeamRepository.findAll();

    }

    public Team getTeamById(Integer id) {
        return TeamRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The Team with this id doesn't exist: %s",id)));
    }

    public void updateTeams(Team Team){
        TeamRepository.findById(Team.getIdTeam()).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The Team doesn't exist")));
        TeamRepository.save(Team);
    }

    public void deleteTeams(Integer idTeam){
        Team TeamFound = TeamRepository.findById(idTeam).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The Team doesn't exist")));

        TeamRepository.delete(TeamFound);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<TotalPlayersByTeamsName> getPlayerByTeamsName(String name) {
        return CompletableFuture.completedFuture(TeamRepository.getTotalPlayersByTeamsName(name));

    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<TotalPlayersByTeamsName>> getPlayerByTeam() {

        return CompletableFuture.completedFuture(TeamRepository.getTotalPlayersByTeam());

    }
}
