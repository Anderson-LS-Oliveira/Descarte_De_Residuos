package ProjetoSolucaoDescarte.solucaoDescarte.controller;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Coleta;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.service.ColetaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ColetaController {
    //solicitar_coleta
    //minhas_solicitacoes

    @Autowired
    private ColetaService coletaService;

    @GetMapping("solicitar_coleta")
    public String solicitar_coleta(){
        return "pagina/solicitar_coleta";
    }

    @GetMapping("minhas_solicitacoes")
    public String minhas_coletas(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        List<Coleta> coletas = coletaService.listaColetas(usuario);
        model.addAttribute("coletas", coletas);
        return "pagina/minhas_solicitacoes";
    }

    @PostMapping("solicitar_coleta")
    public String novaColeta(Coleta coleta, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario != null){
            coletaService.novaColeta(coleta, usuario);
            return "redirect:/minhas_solicitacoes";
        } return "redirect:/login";
    }

    @PostMapping("/excluir_coleta/{id}")
    public String excluirColeta(@PathVariable Long id, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        coletaService.excluirColeta(id, usuario);
        return "redirect:/minhas_coletas";
    }


}
