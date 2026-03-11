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
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

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

    public String getDescricaoResiduo() {
        return descricaoResiduo;
    }

    public void setDescricaoResiduo(String descricaoResiduo) {
        this.descricaoResiduo = descricaoResiduo;
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

    public List<ImagemColeta> getImagensColeta() {
        return imagensColeta;
    }

    public void setImagensColeta(List<ImagemColeta> imagensColeta) {
        this.imagensColeta = imagensColeta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
