package tbd.lab3.backend.repositories;
import java.util.List;

import org.bson.Document;
import tbd.lab3.backend.models.Voluntarios;

public interface VoluntariosRepository {
    public int countVoluntarios();
    public List<Voluntarios> getVoluntarios();
    public Voluntarios createVoluntario(Voluntarios voluntarios);
}
