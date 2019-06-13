package utn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import utn.demo.model.Persona;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Integer> {

    String NATIVE_QUERY = "Select p.nombre, count(v.id) as cantidad from persona p inner join vote v on p.id = persona_id group by p.nombre";

    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<VotosPorCandidato> getVotosPorCandidato();
}
