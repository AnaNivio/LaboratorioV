package com.example.PracticaParcial.controller;

import com.example.PracticaParcial.interfaces.PlayersMonthsInTeam;
import com.example.PracticaParcial.models.Player;
import com.example.PracticaParcial.repositories.TeamRepository;
import com.example.PracticaParcial.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamRepository teamRepository;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createPlayers(@RequestBody @Valid Player player){

        try {
            playerService.addPlayer(player);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,String.format("An error has occurred while the player was created"));
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Player> getAllPlayres() {

        List<Player> foundPlayers = playerService.getPlayers();

        if(foundPlayers.isEmpty()){
           throw  new HttpClientErrorException(HttpStatus.NO_CONTENT,"There aren't any players uploaded yet");
        }
        return foundPlayers;
    }

    @GetMapping("/proyection")
    public ResponseEntity<List<PlayersMonthsInTeam>> getMonthPlayers() {
        CompletableFuture<List<PlayersMonthsInTeam>> result= playerService.getPlayersMonthInTeam();

        return ResponseEntity.status(HttpStatus.OK)
                .body(result.join());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("")
    public void updatePlayers(@RequestBody @Valid Player player){
        playerService.updatePlayers(player);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletePlayers(@PathVariable Integer idPlayer){
        playerService.deletePlayers(idPlayer);
    }


}
