package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsejosSaludController {
    
    @GetMapping("/consejos-de-salud")
    public String getConsejosSaludPage(){
        return "consejosdesalud";
    }
}
