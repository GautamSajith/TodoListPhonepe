package com.gautam.dao;

import com.gautam.entity.TodoListEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class TodoListEntityDAO extends AbstractDAO<TodoListEntity> {

    public TodoListEntityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public TodoListEntity find(String id) {
        Query query = currentSession().createQuery("FROM TodoListEntity WHERE id = :id");
        query.setParameter("id", id);
        return (TodoListEntity) query.uniqueResult();
    }


    public TodoListEntity save(TodoListEntity entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().toString());
        }
        return persist(entity);
    }

    // Method to get all tasks
    // Method to get all tasks using a named query
    public List<TodoListEntity> findAll() {
        TypedQuery<TodoListEntity> query = currentSession().createNamedQuery("com.gautam.entity.TodoListEntity.findAll", TodoListEntity.class);
        return query.getResultList();
    }


    //Method to delete a task
    public void delete(TodoListEntity task) {
        currentSession().delete(task);
    }


}
