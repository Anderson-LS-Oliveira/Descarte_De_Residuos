package ProjetoSolucaoDescarte.solucaoDescarte.entity;

import jakarta.persistence.*;

@Entity
public class ImagemDenuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caminhoImagem;

    @ManyToOne
    @JoinColumn(name = "denuncia_id")
    private Denuncia denuncia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
}
