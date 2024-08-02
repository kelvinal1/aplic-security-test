package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findByPk(@PathVariable int id) {
        return personaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable int id, @RequestBody Persona personaDetails) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaDetails.getNombre());
                    persona.setApellido(personaDetails.getApellido());
                    persona.setDni(personaDetails.getDni());
                    persona.setCelular(personaDetails.getCelular());
                    persona.setCorreo(personaDetails.getCorreo());
                    Persona updatedPersona = personaRepository.save(persona);
                    return ResponseEntity.ok(updatedPersona);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
