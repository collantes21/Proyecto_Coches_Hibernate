package com.example.proyecto_coches_hibernate.util;


import com.example.proyecto_coches_hibernate.model.Coche;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConf {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {

            /*
             *  Hibernate facilita proporcionar las configuraciones en un archivo XML (como hibernate.cfg.xml)
             *   o un archivo de propiedades (como hibernate.properties).
             */
            //en mi caso me gusta trabajar con el fichero de propiedades
            Configuration configuration = new Configuration();
            // Configuracion de Hibernate equivalente al fichero de propiedades  hibernate.cfg.xml's
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/coches");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "toor");

            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            settings.put(Environment.SHOW_SQL, "false");
            settings.put(Environment.HBM2DDL_AUTO, "update");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Coche.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            factory = configuration.buildSessionFactory(serviceRegistry);
        }

        return factory;
    }
}
