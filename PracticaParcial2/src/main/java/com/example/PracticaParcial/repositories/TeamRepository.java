package com.example.PracticaParcial.repositories;

import com.example.PracticaParcial.interfaces.TotalPlayersByTeamsName;
import com.example.PracticaParcial.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//no habia puesto el tag repository
//cambie el nombre de las columnas antes de darme cuenta del error de arriba...no se si soluciona algun problema, pero es conveniente a la hora de escribir codigo

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

    @Query(value ="SELECT T.NAME,COUNT(P.ID_PLAYER)AS CANTPLAYERS FROM TEAM T LEFT JOIN PLAYER P ON P.ID_TEAM=T.ID_TEAM GROUP BY T.NAME", nativeQuery=true)
    List<TotalPlayersByTeamsName> getTotalPlayersByTeam();

    @Query(value = "SELECT T.NAME,COUNT(P.ID_PLAYER)AS CANTPLAYERS " +
                    "FROM TEAM T " +
                    "LEFT JOIN PLAYER P " +
                    "ON P.ID_TEAM = T.ID_TEAM " +
                    "WHERE T.NAME = ?1 " +
                    "GROUP BY T.NAME"
            , nativeQuery=true)
    TotalPlayersByTeamsName getTotalPlayersByTeamsName(String team);

    //no puse el group by. Uno de los errores me pedia que incroporara el campo name dentro de un group by
}
