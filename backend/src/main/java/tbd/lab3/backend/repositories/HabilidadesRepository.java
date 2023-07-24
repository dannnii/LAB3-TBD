package tbd.lab3.backend.repositories;
import java.util.List;

import org.bson.Document;
import tbd.lab3.backend.models.Habilidades;

public interface HabilidadesRepository {
    public int countHabilidades();
    public List<Habilidades> getHabilidades();
    public Habilidades createHabilidad(Habilidades habilidades);
}
