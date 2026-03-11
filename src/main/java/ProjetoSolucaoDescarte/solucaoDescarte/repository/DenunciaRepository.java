package ProjetoSolucaoDescarte.solucaoDescarte.repository;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Denuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    List<Denuncia> findByUsuario(Usuario usuario);
}
