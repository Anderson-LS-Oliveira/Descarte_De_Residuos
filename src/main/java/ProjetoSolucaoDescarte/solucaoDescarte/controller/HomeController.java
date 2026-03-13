package ProjetoSolucaoDescarte.solucaoDescarte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(){
    return "index";
    }

    @GetMapping("instrucoes")
    public String instrucoes(){
        return "pagina/instrucoes";
    }

    @GetMapping("/pontos_coleta")
    public String pontosColeta() {
        return "pagina/pontos_coleta";
    }


}
