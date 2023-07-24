package cl.usach.tbd.lab_3.Models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;


public class Voluntarios {
    @BsonId
    ObjectId _id;  //id_voluntario

    String nombre;
    String apellido;
    String telefono;
    String direccion;

    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
    public String getStringId(){
        return this._id.toString();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
