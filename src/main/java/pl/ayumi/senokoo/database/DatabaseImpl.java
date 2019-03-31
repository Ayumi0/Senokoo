package pl.ayumi.senokoo.database;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;

public class DatabaseImpl implements Database {
    private String host, user, password;
    private Integer port;

    private ArangoDB database;
    public DatabaseImpl(String host, Integer port, String user, String password ) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
        database = new ArangoDB.Builder().host(host, port).user(user).password(password).build();
        System.out.println("Successfully connected host: " + host + " port: " + port + " user: " + user);
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public Integer getPort() {
        return port;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void createDatabase(String databasename) {
        try {
            database.createDatabase(databasename);
        }catch (ArangoDBException ex){
            System.out.println("Can not create Database, Error: " + ex);
        }
    }

    @Override
    public void createCollection(String databasename, String collectionname) {

        try{
            database.db(databasename).createCollection(collectionname);
            System.out.println("Successfully created Collection: " + collectionname + " in Database: " + databasename);
        }catch (ArangoDBException ex){
            System.out.println("Can not create Collection: " + ex);
        }
    }

    @Override
    public void createDocument(String databasename, String collectionname, BaseDocument document) {

        try{
            database.db(databasename).collection(collectionname).insertDocument(document);
            System.out.println("Successfully created document:" + document.getKey() + " in Database: " + databasename + " in Collection: " + collectionname);
        }catch (ArangoDBException ex){
            System.out.println("Can not create Document: " + ex);
        }
    }

    @Override
    public void deleteDocument(String databasename, String collectionname, String key) {

        try{
            database.db(databasename).collection(collectionname).deleteDocument(key);
            System.out.println("Successfully deleted document: " + key + "in Database: " + databasename + " in Collection: " + collectionname);
        }catch (ArangoDBException ex){
            System.out.println("Can not delete document: " + ex);
        }
    }

    @Override
    public void updateDocument(String databasename, String collectionname, String key, BaseDocument updatedDocument) {

        database.db(databasename).collection(collectionname).updateDocument(key, updatedDocument);
        System.out.println("Updated document: " + key);
    }

    @Override
    public BaseDocument getDocument(String databasename, String collectionname, String key) {
        if(database.db(databasename).collection(collectionname).documentExists(key)){
            return database.db(databasename).collection(collectionname).getDocument(key, BaseDocument.class);
        } else {
            System.out.println("Can not find document: " + key);
            return null;
        }
    }

    @Override
    public boolean databaseExist(String databasename) {
        return database.db(databasename).getInfo() != null;

    }

    @Override
    public boolean collectionExist(String databasename, String collectionname) {
        return database.db(databasename).collection(collectionname).getInfo() != null;
    }

    @Override
    public boolean documentExist(String databasename, String collectionname, String key) {
        return database.db(databasename).collection(collectionname).documentExists(key);
    }
}
