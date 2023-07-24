package tbd.lab3.backend.repositories;
import java.util.List;

import org.bson.Document;
import tbd.lab3.backend.models.Habilidades;

public interface HabilidadesRepository {
    public List<Habilidades> findAll();
    public void create(Habilidades habilidad);
    public Habilidades findById(Long id);
    public void update(Habilidades habilidad);
}
