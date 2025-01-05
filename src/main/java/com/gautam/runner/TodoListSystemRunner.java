package com.gautam.runner;

import com.gautam.config.TLSConfiguration;
import com.gautam.dao.TodoListEntityDAO;
import com.gautam.entity.TodoListEntity;
import com.gautam.resource.TodoListResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TodoListSystemRunner extends Application<TLSConfiguration> {

    public static void main(String args[]) throws Exception {
        new TodoListSystemRunner().run(args);
    }


    @Override
    public void run(TLSConfiguration configuration, Environment environment) throws Exception {
        System.out.println("Running");
        TodoListEntityDAO todoListEntityDAO = new TodoListEntityDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new TodoListResource(todoListEntityDAO));
    }

    HibernateBundle<TLSConfiguration> hibernateBundle = new HibernateBundle<TLSConfiguration>(TodoListEntity.class) {

        @Override
        public PooledDataSourceFactory getDataSourceFactory(TLSConfiguration brsConfiguration) {
            return brsConfiguration.getDataSourceFactory();
        }
    };

    public void initialize(Bootstrap<TLSConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }
}
