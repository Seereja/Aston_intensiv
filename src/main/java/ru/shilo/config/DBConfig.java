package ru.shilo.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import ru.shilo.model.Child;
import ru.shilo.model.Section;
import ru.shilo.model.Teacher;
import ru.shilo.model.User;

import java.util.Properties;


public class DBConfig {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Child.class)
                    .addAnnotatedClass(Section.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(User.class);

            Properties settings = new Properties();
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/sports_db");
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "1234");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperties(settings);


            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
