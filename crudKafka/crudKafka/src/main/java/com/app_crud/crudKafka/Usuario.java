package com.app_crud.crudKafka;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    private String id;
    private String nombre;
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
    
}