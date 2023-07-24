package tbd.lab3.backend.services;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tbd.lab3.backend.models.Voluntarios;
import tbd.lab3.backend.repositories.VoluntariosRepository;


@RestController
public class VoluntariosService {

    private final VoluntariosRepository voluntariosRepository;
    VoluntariosService(VoluntariosRepository voluntariosRepository){
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
