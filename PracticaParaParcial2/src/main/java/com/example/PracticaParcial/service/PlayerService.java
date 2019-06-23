package com.example.PracticaParcial.service;

import com.example.PracticaParcial.interfaces.PlayersMonthsInTeam;
import com.example.PracticaParcial.models.Player;
import com.example.PracticaParcial.models.Team;
import com.example.PracticaParcial.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<PlayersMonthsInTeam>> getPlayersMonthInTeam(){
        return CompletableFuture.completedFuture(playerRepository.getPlayersMonthsInTeam());
    }
}
