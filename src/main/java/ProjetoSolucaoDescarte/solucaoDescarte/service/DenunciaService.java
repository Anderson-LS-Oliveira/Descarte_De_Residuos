package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Denuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.StatusDenuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.DenunciaRepository;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ImagemDenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private final DenunciaRepository denunciaRepository;
    @Autowired
    private final ImagemDenunciaRepository imagemDenunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository, ImagemDenunciaRepository imagemDenunciaRepository) {
        this.denunciaRepository = denunciaRepository;
        this.imagemDenunciaRepository = imagemDenunciaRepository;
    }

    public List<Denuncia> listaDenuncias(Usuario usuario){
        return denunciaRepository.findByUsuario(usuario);
    }

    public void novaDenuncia(Denuncia denuncia, Usuario usuario){
        denuncia.setUsuario(usuario);
        denuncia.setStatus(StatusDenuncia.ENVIADA);
        denunciaRepository.save(denuncia);
    }

    public void excluirDenuncia(Long id, Usuario usuario){
        Denuncia denuncia = denunciaRepository.findById(id).orElse(null);

        if (denuncia != null && denuncia.getUsuario().getId().equals(usuario.getId())) {
            denunciaRepository.deleteById(id);
        }
    }
}
