package fr.mimifan.mongobasics.dbManagement;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserManipulation {

    public static void createUser(UUID uuid, String name){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        DBObject newUser = new BasicDBObject("uuid", uuid.toString());
        newUser.put("uuid", uuid.toString());
        newUser.put("username", name);
        newUser.put("rank", "Player");
        newUser.put("premium", null);
        newUser.put("first-join", format.format(now));
        newUser.put("last-login", format.format(now));
        newUser.put("last-logout", null);
        newUser.put("currently-logged", true);

        dbClient.players_collection.insert(newUser);
    }

    public static void updateUser(UUID uuid, HashMap<String, String> doc_value){
        DBObject updated = new BasicDBObject("uuid", uuid.toString());
        for(String docs : doc_value.keySet()){
            updated.put(docs, doc_value.get(docs));
        }
        dbClient.players_collection.insert(updated);
    }

    public static void updateUser(UUID uuid, String document, Object value) {
        DBObject user = new BasicDBObject("uuid", uuid.toString());
        DBObject found = dbClient.players_collection.findOne(user);
        if (found == null) throw new NullPointerException("The user with uuid \" + uuid.toString() + \" doesn't exist in database, can not update.");
        BasicDBObject updated = new BasicDBObject("$set", user);
        updated.append("$set", new BasicDBObject(document, value));
        dbClient.players_collection.update(found, updated);
    }

    public static void updateUser(UUID uuid, String document, Date now){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DBObject user = new BasicDBObject("uuid", uuid.toString());
        DBObject found = dbClient.players_collection.findOne(user);
        if(found==null) throw new NullPointerException("The user with uuid " + uuid.toString() + " doesn't exist in database, can not update last login.");
        if(document != "last-login" && document != "last-logout") throw new NullPointerException("This date row doesn't exist. Can not update date.");
        BasicDBObject updated = new BasicDBObject("$set", user);
        updated.append("$set", new BasicDBObject(document, format.format(now)));
        dbClient.players_collection.update(found, updated);
    }
}
