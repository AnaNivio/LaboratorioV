package com.example.PracticaParcial.service;

import com.example.PracticaParcial.interfaces.PlayersMonthsInTeam;
import com.example.PracticaParcial.models.Player;
import com.example.PracticaParcial.models.Team;
import com.example.PracticaParcial.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Objects.isNull;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

    public List<Player> getPlayers(){

        return  playerRepository.findAll();

    }

    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The player with this id doesn't exist: %s",id)));
    }

    public void updatePlayers(Player player){
        playerRepository.findById(player.getIdPlayer()).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The player doesn't exist")));
        playerRepository.save(player);
    }

    public void deletePlayers(Integer idPlayer){
        Player playerFound = playerRepository.findById(idPlayer).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("The player doesn't exist")));

        playerRepository.delete(playerFound);
    }

    //Proyections
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<PlayersMonthsInTeam>> getPlayersMonthInTeam(){
        return CompletableFuture.completedFuture(playerRepository.getPlayersMonthsInTeam());
    }

}
