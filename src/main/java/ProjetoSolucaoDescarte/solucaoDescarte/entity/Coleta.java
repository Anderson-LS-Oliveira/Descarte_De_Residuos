package ProjetoSolucaoDescarte.solucaoDescarte.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoResiduo;
    private String endereco;
    private String categoria_residuo;

    @OneToMany(mappedBy = "coleta")
    private List<ImagemColeta> imagensColeta;

    public Coleta(){
    }

    public Coleta(String descricaoResiduo, String endereco, String categoria_residuo) {
        this.descricaoResiduo = descricaoResiduo;
        this.endereco = endereco;
        this.categoria_residuo = categoria_residuo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrescricaoResiduo() {
        return descricaoResiduo;
    }

    public void setDrescricaoResiduo(String drescricaoResiduo) {
        this.descricaoResiduo = drescricaoResiduo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoriaResiduo() {
        return categoria_residuo;
    }

    public void setCategoriaResiduo(String categoriaResiduo) {
        this.categoria_residuo = categoriaResiduo;
    }

    public List<ImagemColeta> getImagensColeta() {
        return imagensColeta;
    }

    public void setImagensColeta(List<ImagemColeta> imagensColeta) {
        this.imagensColeta = imagensColeta;
    }
}
