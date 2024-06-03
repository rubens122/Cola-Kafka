package com.app_crud.crudKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping(path="/listar")
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> listarUsuarioId(@PathVariable String id) {
        return this.usuarioRepo.findById(id);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @PutMapping(path="/actualizar/{id}")
    public @ResponseBody String updateUser(@PathVariable String id, @RequestBody Usuario usuario) {
        Usuario usuarioExiste = usuarioRepo.findById(id).orElseThrow();
        usuarioExiste.setNombre(usuario.getNombre());
        usuarioRepo.save(usuarioExiste);
        return "Usuario actualizado";
    }

    @DeleteMapping(path="/borrar/{id}")
    public @ResponseBody String deleteUser(@PathVariable String id) {
        usuarioRepo.deleteById(id);
        return "Usuario eliminado";
    }
}
