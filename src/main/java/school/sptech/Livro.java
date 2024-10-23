package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro() {
        this.avaliacoes = new ArrayList<>();
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrela){

        if(!(descricao == null) && !descricao.isBlank() && !(qtdEstrela == null) && qtdEstrela >= 0 && qtdEstrela <= 5){
            this.avaliacoes.add(new Avaliacao(descricao, qtdEstrela));
        }
    }
    public Double calcularMediaAvaliacoes(){

        Double totalEstrelas = 0.0;
        for(Avaliacao i : avaliacoes){
            totalEstrelas += i.getQtdEstrelas();
        }
        return avaliacoes.size() == 0 ? 0 : totalEstrelas / avaliacoes.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
