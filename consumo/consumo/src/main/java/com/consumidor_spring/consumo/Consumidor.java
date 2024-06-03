package com.consumidor_spring.consumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumidor {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @KafkaListener(topics = "usuarios", groupId = "group_id")
    public void consume(String mensaje) {
        String[] datos = mensaje.split(",");
        Usuario usuario = new Usuario();
        usuario.setId(datos[0]);
        usuario.setNombre(datos[1]);
        usuarioRepo.save(usuario);
    }
}
