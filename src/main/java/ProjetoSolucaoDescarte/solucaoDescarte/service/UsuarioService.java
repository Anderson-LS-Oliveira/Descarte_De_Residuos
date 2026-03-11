package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public boolean autenticar(String email, String senha, HttpSession session) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)){
            session.setAttribute("usuarioLogado", usuario);
            return true;
        }
        return false;
    }

}
