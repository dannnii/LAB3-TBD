package cl.usach.tbd.lab_3.Repositories;

import cl.usach.tbd.lab_3.Models.Voluntarios;

import java.util.List;

public interface VoluntariosRepository {
    public int countVoluntarios();
    public List<Voluntarios> getVoluntarios();
    public Voluntarios createVoluntario(Voluntarios voluntarios);
}
