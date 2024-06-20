package org.example.tp_j2ee.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class BaseRepository <T>{
    protected StandardServiceRegistry registry;

    protected SessionFactory sessionFactory;

    protected Session session;

    public BaseRepository(){
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public abstract T add(T entity);

    public abstract  T finfById(int id);

    public abstract T update(T entity);

    public abstract boolean delete(T entity);


}
