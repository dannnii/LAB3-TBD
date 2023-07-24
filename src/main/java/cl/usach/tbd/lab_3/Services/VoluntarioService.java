package cl.usach.tbd.lab_3.Services;

import cl.usach.tbd.lab_3.Models.Voluntarios;
import cl.usach.tbd.lab_3.Repositories.Impl.VoluntariosRepositoryImpl;
import cl.usach.tbd.lab_3.Repositories.VoluntariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioService {

    private final VoluntariosRepositoryImpl voluntariosRepository;
    @Autowired
    VoluntarioService(VoluntariosRepositoryImpl voluntariosRepository){
        this.voluntariosRepository = voluntariosRepository;
    }

    @GetMapping("/voluntarios/count")
    public String countDogs(){
        int total = voluntariosRepository.countVoluntarios();
        return String.format("Tienes %s voluntarios!!", total);
    }

    @GetMapping("/voluntarios")
    public List<Voluntarios> getVoluntarios(){
        return voluntariosRepository.getVoluntarios();
    }

    @PostMapping("/voluntarios")
    @ResponseBody
    public Voluntarios createVoluntario(@RequestBody Voluntarios voluntarios){
        Voluntarios result = voluntariosRepository.createVoluntario(voluntarios);
        return result;
    }
}
