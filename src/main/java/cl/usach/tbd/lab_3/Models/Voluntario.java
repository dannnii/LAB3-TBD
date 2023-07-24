package cl.usach.tbd.lab_3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class Voluntario {
    @JsonIgnore
    @BsonId
    ObjectId _id;  //id_voluntario

    String nombre;
    String apellido;
    String telefono;
    String direccion;
    List<Habilidad> habilidades;
}
