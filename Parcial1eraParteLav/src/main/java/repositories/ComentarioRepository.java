package repositories;

import models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
    @Query("DELETE FROM Comentario WHERE MINUTE(NOW()) - MINUTE(votesDate) =5;")
    void deleteComentariosInFiveMinutes();
}
