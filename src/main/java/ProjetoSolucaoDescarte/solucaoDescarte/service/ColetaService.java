package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Coleta;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.ImagemColeta;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.StatusColeta;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ColetaRepository;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ImagemColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
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

    public void novaColeta(Coleta coleta, Usuario usuario, MultipartFile[] imagens){
        coleta.setUsuario(usuario);
        coleta.setStatus(StatusColeta.ENVIADA);
        coleta.setDataCriacao(LocalDate.now());
        Coleta coletaSalva = coletaRepository.save(coleta);

        String pastaUpload = "uploads/";

        try {
            Files.createDirectories(Paths.get(pastaUpload));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MultipartFile file : imagens){
            if(!file.isEmpty()){
                try{

                    String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    Path caminho = Paths.get(pastaUpload + nomeArquivo);
                    Files.write(caminho, file.getBytes());

                    ImagemColeta imagem = new ImagemColeta();
                    imagem.setColeta(coletaSalva);
                    imagem.setCaminhoImagem(nomeArquivo);

                    imagemColetaRepository.save(imagem);

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void excluirColeta(Long id, Usuario usuario){
        Coleta coleta =  coletaRepository.findById(id).orElse(null);

        if (coleta != null && coleta.getUsuario().getId().equals(usuario.getId())){
            coletaRepository.deleteById(id);
        }
    }

}
