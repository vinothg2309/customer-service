package com.example.customerservice;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ClusterSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.scheduling.config.ScheduledTask;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Configuration
public class SpringMongoConfiguration extends AbstractMongoClientConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    public MongoClient mongoClient() {
      /*  String host = System.getenv("MONGODB_HOST");
        String db_name = System.getenv("MONGO_DB_NAME");
        String port = System.getenv("MONGO_DB_PORT");*/
        String host = System.getenv("MONGODB_STATEFUL_HOST");
        log.info("System.getenv : username --> " +System.getenv("MONGO_USERNAME")
                +"pwd --> " +System.getenv("MONGO_PASSWORD")
                +"host --> " +host);
        username = username.replaceAll("[\\t\\n\\r\\s]+","");
        password = password.replaceAll("[\\t\\n\\r\\s]+","");
        log.info("Env value after replace: username --> " +username+"pwd --> " +password);
        boolean isBase64Username = org.apache.tomcat.util.codec.binary.Base64.isBase64(username);
        String encodedUserNameString = isBase64Username?new String(Base64.getDecoder().decode(username)):username;
        boolean isBase64Pwd = org.apache.tomcat.util.codec.binary.Base64.isBase64(password);
        String encodedPwdString = isBase64Pwd?new String(Base64.getDecoder().decode(password)):password;
        log.info("encodedUserNameString --> " +encodedUserNameString+"\n encodedPwdString --> " +encodedPwdString);
       // log.info("connection url ---> mongodb://"+encodedUserNameString+":"+encodedPwdString+"@"+mongoHost+":"+mongoPort);
       // return MongoClients.create("mongodb://"+encodedUserNameString+":"+encodedPwdString+"@"+(host!=null?host:mongoHost)+":"+mongoPort);
        log.info("connection url ---> mongodb://"+(host!=null?host:mongoHost)+":"+mongoPort);
        return MongoClients.create("mongodb://"+(host!=null?host:mongoHost)+":"+mongoPort);
    }

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }
}


