package cl.usach.tbd.lab_3.Services;

import cl.usach.tbd.lab_3.Models.Voluntario;
import cl.usach.tbd.lab_3.Repositories.Impl.VoluntarioRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioService {

    Logger logger = LoggerFactory.getLogger(VoluntarioService.class);

    private final VoluntarioRepositoryImpl voluntarioRepository;
    @Autowired
    VoluntarioService(VoluntarioRepositoryImpl voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/voluntarios/count")
    public String countVoluntarios(){
        int total = voluntarioRepository.countVoluntarios();
        return String.format("Tienes %s voluntarios!!", total);
    }

    @GetMapping("/voluntarios")
    public List<Voluntario> getVoluntarios(){
        logger.info("Obteniendo voluntarios");
        return voluntarioRepository.getVoluntarios();
    }

    @PostMapping("/voluntarios")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        logger.info("Creando voluntario");
        Voluntario result = voluntarioRepository.createVoluntario(voluntario);
        return result;
    }

    @GetMapping("/voluntarios/totalHabilidades")
    public int getTotalHabilidades(){
        logger.info("Obteniendo total de habilidades");
        return voluntarioRepository.getTotalHabilidades();
    }
}
