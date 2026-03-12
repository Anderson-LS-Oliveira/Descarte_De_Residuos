package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Coleta;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.StatusColeta;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ColetaRepository;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ImagemColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColetaService {

    @Autowired
    private final ColetaRepository coletaRepository;
    @Autowired
    private final ImagemColetaRepository imagemColetaRepository;

    public ColetaService(ColetaRepository coletaRepository, ImagemColetaRepository imagemColetaRepository) {
        this.coletaRepository = coletaRepository;
        this.imagemColetaRepository = imagemColetaRepository;
    }

    public List<Coleta> listaColetas(Usuario usuario){
        return coletaRepository.findByUsuario(usuario);
    }

    public void novaColeta(Coleta coleta, Usuario usuario){
        coleta.setUsuario(usuario);
        coleta.setStatus(StatusColeta.ENVIADA);
        coletaRepository.save(coleta);
    }

    public void excluirColeta(Long id, Usuario usuario){
        Coleta coleta =  coletaRepository.findById(id).orElse(null);

        if (coleta != null && coleta.getUsuario().getId().equals(usuario.getId())){
            coletaRepository.deleteById(id);
        }
    }

}
