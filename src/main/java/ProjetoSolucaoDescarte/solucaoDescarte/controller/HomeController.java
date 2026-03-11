package ProjetoSolucaoDescarte.solucaoDescarte.controller;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/cadastro")
    public String cadastro(){
        return "/pagina/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "pagina/login";
    }

    @PostMapping("/login")
    public String autenticar(String email, String senha, HttpSession session){
        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario != null && usuario.getSenha().equals(senha)){
            session.setAttribute("usuarioLogado", usuario);
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
