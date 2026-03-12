package ProjetoSolucaoDescarte.solucaoDescarte.repository;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Coleta;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColetaRepository extends JpaRepository<Coleta, Long> {

    List<Coleta> findByUsuario(Usuario usuario);
}
