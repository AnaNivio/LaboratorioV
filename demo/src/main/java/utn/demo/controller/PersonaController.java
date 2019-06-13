package utn.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import utn.demo.model.Persona;
import utn.demo.model.Vote;
import utn.demo.repositories.PersonaRepository;
import utn.demo.repositories.VotosPorCandidato;

import java.util.List;

@RequestMapping("/persona")
@RestController
public class PersonaController {

    private static final String PERSON_NOT_FOUND = "No existe la persona con el id: %s";

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping("")
    public void addPersona(@RequestBody final Persona p) {
        personaRepository.save(p);
    }

    @GetMapping("")
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @PostMapping("/{id}/vote")
    public void votePerson(@PathVariable final Integer id, @RequestBody final Vote vote) {
        Persona p = personaRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id)));
        p.getVotes().add(vote);
        vote.setPersona(p);
        personaRepository.save(p);
    }

    @GetMapping("/Native")
    public List<VotosPorCandidato> getVotosPorCandidato(){
        return personaRepository.getVotosPorCandidato();
    }
}
