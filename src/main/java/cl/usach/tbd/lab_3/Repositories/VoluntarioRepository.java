package cl.usach.tbd.lab_3.Repositories;

import cl.usach.tbd.lab_3.Models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public int countVoluntarios();
    public List<Voluntario> getVoluntarios();
    public Voluntario createVoluntario(Voluntario voluntario);
    public int getTotalHabilidades();
}
