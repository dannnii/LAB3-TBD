package cl.usach.tbd.lab_3.Repositories.Impl;

import cl.usach.tbd.lab_3.Models.Voluntarios;
import cl.usach.tbd.lab_3.Repositories.VoluntariosRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class VoluntariosRepositoryImpl implements VoluntariosRepository {

    @Autowired
    MongoDatabase database;
    @Override
    public int countVoluntarios() {
        MongoCollection<Document> collection = database.getCollection("voluntarios");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Voluntarios> getVoluntarios() {
        MongoCollection<Voluntarios> collection = database.getCollection("dog", Voluntarios.class);
        List <Voluntarios> voluntarios = collection.find().into(new ArrayList<>());

        return voluntarios;
    }

    @Override
    public Voluntarios createVoluntario(Voluntarios voluntarios) {
        MongoCollection<Voluntarios> collection = database.getCollection("voluntarios", Voluntarios.class);
        collection.insertOne(voluntarios);
        return voluntarios;
    }
}
