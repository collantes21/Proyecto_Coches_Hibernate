package com.example.proyecto_coches_hibernate.dao;

import com.example.proyecto_coches_hibernate.model.Coche;
import com.example.proyecto_coches_hibernate.util.HibernateConf;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.transaction.SystemException;
import java.util.List;


public class CocheDAO implements CocheInterface{

    private SessionFactory factory = HibernateConf.getFactory();

    @Override
    public void guardarCoche(Coche coche) throws SystemException {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(coche);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public void modificarCoche(Coche coche) {
        org.hibernate.Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(coche);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public void borrarCoche(String matricula) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Coche user = session.get(Coche.class, matricula);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public List<Coche> listarCoches() {
        Transaction transaction = null;
        List<Coche> coches = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            coches = session.createQuery("from Coche").list();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
        return coches;
    }
}
