package com.gautam.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import java.util.Objects;


public class TLSConfiguration extends Configuration {

    private DataSourceFactory dataSourceFactory;

//    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        if(Objects.isNull(dataSourceFactory))
            dataSourceFactory = new DataSourceFactory();

        return dataSourceFactory;
    }

//    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
}
