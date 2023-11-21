package com.example.proyecto_coches_hibernate.dao;

import com.example.proyecto_coches_hibernate.model.Coche;

import javax.transaction.SystemException;
import java.util.List;

public interface CocheInterface {

    void guardarCoche(Coche coche) throws SystemException;

    void modificarCoche(Coche coche);
    void borrarCoche(String matricula);

    List<Coche> listarCoches();
}
