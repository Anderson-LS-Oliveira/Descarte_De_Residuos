package ProjetoSolucaoDescarte.solucaoDescarte.entity;

import jakarta.persistence.*;

@Entity
public class ImagemColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caminhoImagem;

    @ManyToOne
    @JoinColumn(name = "Coleta_id")
    private Coleta Coleta;

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

    public Coleta getColeta() {
        return Coleta;
    }

    public void setColeta(Coleta coleta) {
        Coleta = coleta;
    }
}
