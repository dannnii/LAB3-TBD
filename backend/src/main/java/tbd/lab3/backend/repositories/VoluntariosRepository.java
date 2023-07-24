package tbd.lab3.backend.repositories;
import java.util.List;

import org.bson.Document;
import tbd.lab3.backend.models.Voluntarios;

public interface VoluntariosRepository {
    public List<Voluntarios> findAll();

    public Voluntarios findById( Long _id);

    public void create(Voluntarios voluntario);

    public void update(Voluntarios voluntario);
}
