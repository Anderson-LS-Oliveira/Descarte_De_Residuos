package ProjetoSolucaoDescarte.solucaoDescarte.entity;

import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.CategoriaResiduo;
import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.StatusColeta;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoResiduo;
    private String endereco;
    private LocalDate dataCriacao;

    @Enumerated(EnumType.STRING)
    private CategoriaResiduo categoria_residuo;
    @Enumerated(EnumType.STRING)
    private StatusColeta status;

    @OneToMany(mappedBy = "coleta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagemColeta> imagensColeta;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Coleta(){
    }

    public Coleta(String descricaoResiduo, String endereco, LocalDate dataCriacao, CategoriaResiduo categoria_residuo, StatusColeta status, Usuario usuario) {
        this.descricaoResiduo = descricaoResiduo;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
        this.categoria_residuo = categoria_residuo;
        this.status = status;
        this.usuario = usuario;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public CategoriaResiduo getCategoria_residuo() {
        return categoria_residuo;
    }

    public void setCategoria_residuo(CategoriaResiduo categoria_residuo) {
        this.categoria_residuo = categoria_residuo;
    }

    public StatusColeta getStatus() {
        return status;
    }

    public void setStatus(StatusColeta status) {
        this.status = status;
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
