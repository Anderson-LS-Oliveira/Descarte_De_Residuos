package ProjetoSolucaoDescarte.solucaoDescarte.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String endereco;
    private String categoria_residuo;
    private LocalDate dataOcorrencia;

    @OneToMany(mappedBy = "denuncia")
    private List<ImagemDenuncia> imagens;

    public Denuncia(){
    }

    public Denuncia(String descricao, String endereco, String categoria_residuo, LocalDate dataOcorrencia) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.categoria_residuo = categoria_residuo;
        this.dataOcorrencia = dataOcorrencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria_residuo() {
        return categoria_residuo;
    }

    public void setCategoria_residuo(String categoria_residuo) {
        this.categoria_residuo = categoria_residuo;
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public List<ImagemDenuncia> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemDenuncia> imagens) {
        this.imagens = imagens;
    }
}
