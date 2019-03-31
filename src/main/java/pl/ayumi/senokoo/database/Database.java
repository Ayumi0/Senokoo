package pl.ayumi.senokoo.database;

import com.arangodb.entity.BaseDocument;

public interface Database {

    String getHost();

    Integer getPort();

    String getUser();

    String getPassword();

    void createDatabase(String databasename);

    void createCollection(String databasename, String collectionname);

    void createDocument(String databasename, String collectionname, BaseDocument document);



    void deleteDocument(String databasename, String collectionname, String key);

    void updateDocument(String databasename, String collectionname, String key, BaseDocument updatedDocument);

    BaseDocument getDocument(String databasename, String collectionname, String key);

    boolean databaseExist(String databasename);

    boolean collectionExist(String databasename, String collectionname);

    boolean documentExist(String databasename, String collectionname, String key);


}
