package fr.mimifan.mongobasics.dbManagement;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import fr.mimifan.mongobasics.dbManagement.players.playersData;
import fr.mimifan.mongobasics.dbManagement.ranks.rankInfos;

import java.util.UUID;

import static fr.mimifan.mongobasics.dbManagement.dbClient.players_collection;
import static fr.mimifan.mongobasics.dbManagement.dbClient.ranks_collection;

public class getData {

    public static boolean isDataInDB(DBCollection collection, String documentName, String documentValue) {
        return !(collection.findOne(new BasicDBObject(documentName, documentValue))==null);
    }

    public static playersData getInfos(UUID uuid){
        DBObject r = new BasicDBObject("uuid", uuid.toString());
        DBObject found = players_collection.findOne(r);
        if(found==null) throw new NullPointerException("The user with uuid " + uuid.toString() + " doesn't exist in database.");
        String username = (String) found.get("username");
        String rank = (String) found.get("rank");
        boolean premium = (boolean) found.get("premium");
        boolean logged = (boolean) found.get("currently-logged");

        
        return new playersData(username, rank, premium, logged);
    }

    public static rankInfos getInfos(String rank){
        DBObject r = new BasicDBObject("rank", rank);
        DBObject found = ranks_collection.findOne(r);
        if(found==null) throw new NullPointerException("The rank " + rank + " doesn't exist in database.");
        String rankName = (String) found.get("rank");
        String prefix = (String) found.get("prefix");
        double priority = (double) found.get("priority");

        return new rankInfos(rankName, prefix, priority);
    }

}
