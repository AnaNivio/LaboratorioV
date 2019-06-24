package com.example.PracticaParcial.repositories;

import com.example.PracticaParcial.models.PlayersQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersQuantityRepository extends JpaRepository<PlayersQuantity,Integer> {
    @Query(value = "SELECT COUNT(*) as Quantity FROM Player",nativeQuery = true)
    public PlayersQuantity getTotalPlayersQuantity();

    @Query(value = "SELECT COUNT(*) as Quantity FROM Player WHERE age >17 ",nativeQuery = true)
    public PlayersQuantity getPlayersQuantityByAgeRange();
}
