package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.ImagemColeta;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ColetaRepository;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ImagemColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
