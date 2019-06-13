package controllers;

import lombok.Data;
import models.Publicacion;
import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import repositories.UsuarioRepository;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void altaUsuarios(@RequestBody @Valid Usuario usuario,@RequestHeader("User-Agent") String userAgent) {

        try {
            usuario.setBrowser(userAgent);
            usuarioRepository.save(usuario);

        } catch (DataIntegrityViolationException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Sucedio un error al crear al usuario"));
        }

    }

    //No hace nada el Updtae; cuando lo encuentro por id, compruebo si esta en el repositorio.... PERO
    //AL LLAMAR AL SAVE, ESTOY GUARNDANDO ESTE OBJETO QUE ENCONTRE.
    /*@ResponseStatus(HttpStatus.OK)
    @PutMapping("/{idUsuario}")
    public void modificarUsuarios(@PathVariable ("idUsuario") Integer idUsuario) {
        Usuario usarioEncontrado= usuarioRepository.findById(idUsuario).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el usuario con el id: %s",idUsuario)));

        usuarioRepository.save(usarioEncontrado);

    }*/

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/usuarioNuevo")
    public void modificarUsuarios(@RequestBody Usuario usuario) {
        Usuario usarioEncontrado= usuarioRepository.findById(usuario.getIdUsuario()).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el usuario con el id: %s",usuario.getIdUsuario())));

        usuarioRepository.save(usuario);

    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuarios(@PathVariable ("idUsuario") Integer idUsuario) {
        Usuario usarioEncontrado= usuarioRepository.findById(idUsuario).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el usuario con el id: %s",idUsuario)));

        usuarioRepository.delete(usarioEncontrado);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, String.format("No hay usuarios cargados aun"));
        }
        return usuarios;
    }

    /*@ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Publicacion> listarPublicacionesUsuario(@Param("idUsuario") Integer idUsuario) {
            Usuario usuario= usuarioRepository.findById(idUsuario).orElseThrow(()->
                    new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("El usuario no existe")));

            List<Publicacion> publicacionesUsuarios=usuario.getPublicaciones();

            if(publicacionesUsuarios.isEmpty()){
                throw  new HttpClientErrorException(HttpStatus.NO_CONTENT,String.format("El usuario aun no hizo ninguna publicacion"));
            }

            return publicacionesUsuarios;

    }
*/
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idUsuario}")
    public Usuario listarUsuarioPorId(@PathVariable ("idUsuario") Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format("No existe el usuario con el id: %s",idUsuario)));

    }






}
