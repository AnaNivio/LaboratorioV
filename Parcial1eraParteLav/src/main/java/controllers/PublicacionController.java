package controllers;

import models.Publicacion;
import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import repositories.PublicacionRepository;
import repositories.UsuarioRepository;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private PublicacionRepository usuarioRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void altaPublicacion(@RequestBody @Valid Publicacion publicacion) {

        try {
            publicacionRepository.save(publicacion);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Sucedio un error al crear la publicacion"));
        }

    }


}
