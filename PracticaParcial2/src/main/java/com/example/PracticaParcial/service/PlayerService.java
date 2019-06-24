package com.example.PracticaParcial.service;

import com.example.PracticaParcial.interfaces.PlayersMonthsInTeam;
import com.example.PracticaParcial.models.PlayersQuantity;
import com.example.PracticaParcial.models.Player;
import com.example.PracticaParcial.repositories.PlayerRepository;
import com.example.PracticaParcial.repositories.PlayersQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayersQuantityRepository playersQuantityRepository;

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

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<PlayersQuantity> getPlayersQuantity(){
        return CompletableFuture.completedFuture(playersQuantityRepository.getTotalPlayersQuantity());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<PlayersQuantity> getPlayersOlderThan17(){
        return CompletableFuture.completedFuture(playersQuantityRepository.getPlayersQuantityByAgeRange());
    }



}
