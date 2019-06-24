package com.example.PracticaParcial.controller;

import com.example.PracticaParcial.interfaces.TotalPlayersByTeamsName;
import com.example.PracticaParcial.models.Team;
import com.example.PracticaParcial.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService TeamService;


    @ResponseStatus(HttpStatus.OK)
    //Returns userAgent string from where the request was made from
    @GetMapping("/header")
    public String getUserAgent(@RequestHeader("User-Agent") String userAgent) {
        return userAgent;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createTeam(@RequestBody @Valid Team team){

        TeamService.addTeam(team);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll") //return entity and not the DTO
    public List<Team> getAllTeams() {
       return TeamService.getTeams();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") Integer id) {
        return TeamService.getTeamById(id);

    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("")
    public void updateTeam(@RequestBody @Valid Team team){
        TeamService.updateTeams(team);
    }



    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable("id") Integer idTeam){
        TeamService.deleteTeams(idTeam);

    }

  //proyections
      @GetMapping("/playersQuantity/{name}")

      public ResponseEntity<TotalPlayersByTeamsName> getPlayerByTeamsName(@PathVariable("name") String name) {
          CompletableFuture<TotalPlayersByTeamsName> result=TeamService.getPlayerByTeamsName(name);
          return ResponseEntity.status(HttpStatus.OK)
          .body(result.join());

      }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/playersByTeams")
    public ResponseEntity<List<TotalPlayersByTeamsName>> getPlayerByTeam() {
        CompletableFuture<List<TotalPlayersByTeamsName>> result=TeamService.getPlayerByTeam();
        return ResponseEntity.status(HttpStatus.OK)
                .body(result.join());

    }
}
