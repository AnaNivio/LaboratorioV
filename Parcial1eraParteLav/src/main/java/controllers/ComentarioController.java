package controllers;

import models.Comentario;
import models.Publicacion;
import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import repositories.ComentarioRepository;
import repositories.PublicacionRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void altaComentario(@RequestBody @Valid Comentario comentario) {

        try {
            comentarioRepository.save(comentario);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Sucedio un error al crear el comentario"));
        }

    }

    //PREGUNTAR SI ESTA BIEN BORRAR POR ID... O SINO BORRO POR EL OBJETO EN SI
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{idComentario}")
    public void eliminarComentario(@PathVariable ("idComentario") Integer idComentario) {
        Comentario comentarioEncontrado= comentarioRepository.findById(idComentario).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el comntario con el id: %s",idComentario)));

        comentarioRepository.delete(comentarioEncontrado);

    }

    @Scheduled(cron = "*/5 * * * *")
    private void deleteComentarioInX(){
        comentarioRepository.deleteComentariosInFiveMinutes();
    }
}
