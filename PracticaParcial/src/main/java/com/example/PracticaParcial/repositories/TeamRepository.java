package com.example.PracticaParcial.repositories;

import com.example.PracticaParcial.interfaces.TotalPlayersByTeamsName;
import com.example.PracticaParcial.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Integer> {

    @Query(value ="SELECT t.teamsName,count(p.idPlayer)as cantPlayers FROM Team t INNER JOIN Player p ON p.idTeam=t.idTeam", nativeQuery=true)
    List<TotalPlayersByTeamsName> getTotalPlayersByTeam();

    @Query(value = "SELECT t.name,count(p.idPlayer)as cantPlayers " +
            "FROM Team t " +
            "LEFT JOIN Player p " +
            "ON p.id_team = t.idTeam " +
            "WHERE t.name = ?1", nativeQuery=true)
    TotalPlayersByTeamsName getTotalPlayersByTeamsName(String team);
}
