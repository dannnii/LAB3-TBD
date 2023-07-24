package cl.usach.tbd.lab_3.Configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.Collections;

@Configuration
public class DatabaseContext {

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {
        // Configuración del cliente de base de datos
        MongoClient mongoClient = MongoClients.create("mongodb+srv://mongodb:mongodb@cluster0.gkcqw4t.mongodb.net/?retryWrites=true&w=majority");
        return new SimpleMongoClientDatabaseFactory(mongoClient, "GestionVoluntarios");
    }

    // Agrega el bean de MongoOperations (MongoTemplate)
    @Bean
    public MongoOperations mongoOperations(MongoDatabaseFactory mongoDatabaseFactory) {
        // Configuración del MongoTemplate
        MappingMongoConverter converter = new MappingMongoConverter(mongoDatabaseFactory, new MongoMappingContext());
        converter.setCustomConversions(new MongoCustomConversions(Collections.emptyList()));
        return new MongoTemplate(mongoDatabaseFactory, converter);
    }

    @Bean
    public MongoDatabase mongoDatabase(MongoDatabaseFactory mongoDatabaseFactory) {
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);
        return mongoDatabaseFactory.getMongoDatabase().withCodecRegistry(pojoCodecRegistry);
    }
}

