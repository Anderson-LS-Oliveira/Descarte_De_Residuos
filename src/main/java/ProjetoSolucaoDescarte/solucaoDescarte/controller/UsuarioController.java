package ProjetoSolucaoDescarte.solucaoDescarte.controller;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.UsuarioRepository;
import ProjetoSolucaoDescarte.solucaoDescarte.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    //cadastro
    //login
    //logout

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String cadastro(){
        return "pagina/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(Usuario usuario){
        usuarioService.cadastrarUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "pagina/login";
    }

    @PostMapping("/login")
    public String autenticar(String email, String senha, HttpSession session){
        boolean autenticado = usuarioService.autenticar(email, senha, session);

        if (autenticado){
            return "redirect:/";
        }
        return "pagina/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
