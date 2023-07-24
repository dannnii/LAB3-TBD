package tbd.lab3.backend.models;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;


public class Habilidades {
    @BsonId
    ObjectId _id;  //id_habilidad

    String habilidad;
    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
    public String getStringId(){
        return this._id.toString();
    }

    public String getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }


}
