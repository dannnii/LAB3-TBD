package cl.usach.tbd.lab_3.Repositories.Impl;

import cl.usach.tbd.lab_3.Models.Voluntario;
import cl.usach.tbd.lab_3.Repositories.VoluntarioRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class VoluntarioRepositoryImpl implements VoluntarioRepository {
    @Autowired
    MongoDatabase database;

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public int countVoluntarios() {
        MongoCollection<Document> collection = database.getCollection("voluntarios");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Voluntario> getVoluntarios() {
        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        List <Voluntario> voluntarios = collection.find().into(new ArrayList<>());

        return voluntarios;
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        MongoCollection<Voluntario> collection = database.getCollection("voluntarios", Voluntario.class);
        collection.insertOne(voluntario);
        return voluntario;
    }

    @Override
    public int getTotalHabilidades() {
        Aggregation aggregation = newAggregation(
                unwind("habilidades"), // Desagrega las listas de habilidades
                group().count().as("totalHabilidades") // Agrupa todos los documentos y cuenta las habilidades
        );

        AggregationResults<Document> result = mongoOperations.aggregate(aggregation, "voluntarios", Document.class);
        List<Document> results = result.getMappedResults();

        if (!results.isEmpty()) {
            Document firstResult = results.get(0);
            return firstResult.getInteger("totalHabilidades", 0);
        } else {
            return 0;
        }
    }
}
