package com.example.PracticaParcial.repositories;

import com.example.PracticaParcial.interfaces.PlayersMonthsInTeam;
import com.example.PracticaParcial.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    @Query(value = "SELECT " +
            "p.name, " +
            "p.surname, " +
            "p.age, " +
            "TIMESTAMPDIFF(month,p.date,curdate()) as MonthsInTeam " +
            "FROM Player p "+
            "WHERE p.age > 20",nativeQuery = true)
    public List<PlayersMonthsInTeam> getPlayersMonthsInTeam();
}
