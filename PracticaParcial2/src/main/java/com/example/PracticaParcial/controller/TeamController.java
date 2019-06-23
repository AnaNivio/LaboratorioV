package com.example.PracticaParcial.controller;

import com.example.PracticaParcial.interfaces.TotalPlayersByTeamsName;
import com.example.PracticaParcial.models.Team;
import com.example.PracticaParcial.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;


    @ResponseStatus(HttpStatus.OK)
    //Returns userAgent string from where the request was made from
    @GetMapping("/header")
    public String getUserAgent(@RequestHeader("User-Agent") String userAgent) {
        return userAgent;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createTeam(@RequestBody @Valid Team team){

        try {
            teamRepository.save(team);
        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,String.format("An error has occurred while the team was created"));
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll") //return entity and not the DTO
    public List<Team> getAllTeams() {
        List<Team> foundTeams = new ArrayList<>();

        foundTeams=teamRepository.findAll();

        if(foundTeams.isEmpty()){
            throw  new HttpClientErrorException(HttpStatus.NO_CONTENT,String.format("There aren't any team uploaded yet"));
        }
        return foundTeams;

    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/playersQuantity/{name}")

    public TotalPlayersByTeamsName getPlayerByTeamsName(@PathVariable("name") String name) {

        return teamRepository.getTotalPlayersByTeamsName(name);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/playersByTeams")
    public List<TotalPlayersByTeamsName> getPlayerByTeam() {

        return teamRepository.getTotalPlayersByTeam();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") Integer id) {
        return teamRepository.findById(id).orElseThrow(()->
                new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The team with this id doesn't exist: %s",id)));

    }
    

/*
  @ResponseStatus(HttpStatus.OK)
    @PutMapping("")
    public void updateTeam(@RequestBody @Valid Team team){
        teamRepository.findById(team.getIdTeam()).orElseThrow(()->
                new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The team doesn't exist")));

        teamRepository.save(team);
    }

*/

  /*  @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") Integer idTeam){
        Team teamFound= teamRepository.findById(idTeam).orElseThrow(()->
                new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The team doesn't exist")));

        teamRepository.delete(teamFound);

    }*/


}
