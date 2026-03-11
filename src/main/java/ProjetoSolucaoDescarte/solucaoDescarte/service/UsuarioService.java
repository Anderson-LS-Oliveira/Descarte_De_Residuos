package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

//    public Usuario criarUsuario(String nome, String email, String senha, String telefone, LocalDate dataNascimento) {
//        Usuario usuario = new Usuario();
//
//        usuario.setNome(nome);
//        usuario.setEmail(email);
//        usuario.setSenha(senha);
//        usuario.setTelefone(telefone);
//        usuario.setDataNascimento(dataNascimento);
//
//        return usuarioRepository.save(usuario);
//    }


}
