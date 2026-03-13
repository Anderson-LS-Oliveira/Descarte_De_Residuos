package ProjetoSolucaoDescarte.solucaoDescarte.service;

import ProjetoSolucaoDescarte.solucaoDescarte.entity.Denuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.ImagemColeta;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.ImagemDenuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.entity.Usuario;
import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.StatusDenuncia;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.DenunciaRepository;
import ProjetoSolucaoDescarte.solucaoDescarte.repository.ImagemDenunciaRepository;
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

    public void novaDenuncia(Denuncia denuncia, Usuario usuario, MultipartFile[] imagens){
        denuncia.setUsuario(usuario);
        denuncia.setStatus(StatusDenuncia.ENVIADA);
        denuncia.setDataCriacao(LocalDate.now());
        Denuncia denunciaSalva = denunciaRepository.save(denuncia);

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

                    ImagemDenuncia imagem = new ImagemDenuncia();
                    imagem.setDenuncia(denunciaSalva);
                    imagem.setCaminhoImagem(nomeArquivo);

                    imagemDenunciaRepository.save(imagem);

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void excluirDenuncia(Long id, Usuario usuario){
        Denuncia denuncia = denunciaRepository.findById(id).orElse(null);

        if (denuncia != null && denuncia.getUsuario().getId().equals(usuario.getId())) {
            denunciaRepository.deleteById(id);
        }
    }
}
