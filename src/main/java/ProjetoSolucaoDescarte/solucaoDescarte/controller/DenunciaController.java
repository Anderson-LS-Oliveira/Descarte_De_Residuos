package ProjetoSolucaoDescarte.solucaoDescarte.controller;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Denuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.service.DenunciaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DenunciaController {
    //registrar_denuncia
    //minhas_denuncias

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping("registrar_denuncia")
    public String registrar_denuncia(){
        return "pagina/registrar_denuncia";
    }

    @GetMapping("minhas_denuncias")
    public String minhas_denuncias(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        List<Denuncia> denuncias = denunciaService.listaDenuncias(usuario);
        model.addAttribute("denuncias", denuncias);
        return "pagina/minhas_denuncias";
    }

    @PostMapping("registrar_denuncia")
    public String novaDenuncia(Denuncia denuncia, @RequestParam("imagens") MultipartFile[] imagens, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario != null) {
            denunciaService.novaDenuncia(denuncia, usuario, imagens);
            return "redirect:/minhas_denuncias";
        } return "redirect:/login";
    }

    @PostMapping("/excluir_denuncia/{id}")
    public String excluirDenuncia(@PathVariable Long id, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        denunciaService.excluirDenuncia(id, usuario);
        return "redirect:/minhas_denuncias";
    }




}
