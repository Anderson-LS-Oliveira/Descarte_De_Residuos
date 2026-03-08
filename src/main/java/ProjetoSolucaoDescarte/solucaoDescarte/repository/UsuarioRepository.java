package ProjetoSolucaoDescarte.solucaoDescarte.repository;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
