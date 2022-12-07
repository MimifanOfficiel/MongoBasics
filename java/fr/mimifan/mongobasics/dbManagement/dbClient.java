package fr.mimifan.mongobasics.dbManagement;


import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;


public class dbClient {

    public static MongoClient mongoClient(String address) {
        ServerAddress addr = new ServerAddress(address, 27017);
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(MongoCredential.createCredential("SilvenyaBot", "Silvenya", "mindA_SilBot_venya_2022".toCharArray()));
        return new MongoClient(addr, credentials);
    }

    public static MongoClient client = mongoClient("82.66.74.10");
    @SuppressWarnings("deprecation")
    public static DB mongodb = client.getDB("Silvenya");
    public static DBCollection players_collection = mongodb.getCollection("players");
    public static DBCollection ranks_collection = mongodb.getCollection("ranks");


}
