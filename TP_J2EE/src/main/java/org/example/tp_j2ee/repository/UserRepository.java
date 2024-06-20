package org.example.tp_j2ee.repository;

import org.example.tp_j2ee.exception.NotFoundException;
import org.example.tp_j2ee.model.User;
import org.hibernate.Transaction;

public class UserRepository extends BaseRepository<User> {
    public UserRepository(){
        super();
    }

    @Override
    public User add(User entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public User finfById(int id) {
        User user = null;

        try {
            session = sessionFactory.openSession();
            user = session.get(User.class,id);
            if (user == null){
                throw new NotFoundException("User not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public User update(User entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public boolean delete(User entity) {
        Transaction transaction = null;
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
            result = true;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return result;
    }

    public User findByUsernamePassword(String username, String password){
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = (User) session.createQuery("from User where username = :username AND password = :password")
                    .setParameter("username",username)
                    .setParameter("password",password)
                    .uniqueResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return user;
    }
}
