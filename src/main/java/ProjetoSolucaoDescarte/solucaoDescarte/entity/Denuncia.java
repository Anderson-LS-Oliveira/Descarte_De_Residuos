package ProjetoSolucaoDescarte.solucaoDescarte.entity;

import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.CategoriaResiduo;
import ProjetoSolucaoDescarte.solucaoDescarte.enumeracao.StatusDenuncia;
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
    private LocalDate dataOcorrencia;
    private LocalDate dataCriacao;

    @Enumerated(EnumType.STRING)
    private CategoriaResiduo categoria_residuo;
    @Enumerated(EnumType.STRING)
    private StatusDenuncia status;

    @OneToMany(mappedBy = "denuncia")
    private List<ImagemDenuncia> imagens;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Denuncia(){
    }

    @PrePersist
    public void prePersist(){
        this.dataCriacao = LocalDate.now();
    }

    public Denuncia(String descricao, String endereco, LocalDate dataOcorrencia, LocalDate dataCriacao, CategoriaResiduo categoria_residuo, StatusDenuncia status, Usuario usuario) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.dataOcorrencia = dataOcorrencia;
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

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
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

    public StatusDenuncia getStatus() {
        return status;
    }

    public void setStatus(StatusDenuncia status) {
        this.status = status;
    }

    public List<ImagemDenuncia> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemDenuncia> imagens) {
        this.imagens = imagens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
