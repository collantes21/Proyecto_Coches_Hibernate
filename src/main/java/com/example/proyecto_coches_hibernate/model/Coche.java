package com.example.proyecto_coches_hibernate.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "coche")
public class Coche {

        @Id
        private String matricula;

        @Column(name = "marca")
        private String marca;
        @Column(name = "modelo")
        private String modelo;

        @Column(name="tipo")
        private String tipo;

    public Coche() {
        super();
    }

    public Coche(String matricula, String marca, String modelo, String tipo) {
        this.matricula = matricula;
        this.marca=marca;
        this.modelo=modelo;
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
