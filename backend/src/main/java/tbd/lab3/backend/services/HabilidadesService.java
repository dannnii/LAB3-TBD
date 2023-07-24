package tbd.lab3.backend.services;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tbd.lab3.backend.models.Habilidades;
import tbd.lab3.backend.repositories.HabilidadesRepository;



@RestController
public class HabilidadesService {

    private final HabilidadesRepository habilidadesRepository;
    HabilidadesService(HabilidadesRepository habilidadesRepository){
        this.habilidadesRepository = habilidadesRepository;
    }
    @GetMapping("/habilidade/count")
    public String countHabilidades(){
        int total = habilidadesRepository.countHabilidades();
        return String.format("Tienes %s habilidades!!", total);
    }

    @GetMapping("/habilidades")
    public List<Habilidades> getHabilidades(){
        return habilidadesRepository.getHabilidades();
    }

    @PostMapping("/habilidade")
    @ResponseBody
    public Habilidades createHabilidad(@RequestBody Habilidades habilidades){
        Habilidades result = habilidadesRepository.createHabilidad(habilidades);
        return result;
    }
}
