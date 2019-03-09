package learning_java.DataBase;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class LinkToMongoDB {
    public static void main(String[] args) {
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("tweet_stream");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("event1");
            System.out.println("集合 event1 选择成功");

            Document document = new Document("name", "MongoDB").
                    append("description", "database").
                    append("likes", 100).
                    append("by", "Fly");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");

//            //删除符合条件的第一个文档
//            collection.deleteOne(Filters.eq("name", "test_data"));
//            //删除所有符合条件的文档
//            collection.deleteMany (Filters.eq("name", "test_data"));

            FindIterable<Document> findIterable = collection.find().limit(2);
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
