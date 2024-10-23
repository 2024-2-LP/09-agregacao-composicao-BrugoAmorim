package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    private String nome;
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){

        if(!(livro == null)){

            Boolean condicao2 = livro.getTitulo() == null || livro.getTitulo().isBlank();
            Boolean condicao3 = livro.getAutor() == null || livro.getAutor().isBlank();
            Boolean condicao4 = livro.getDataPublicacao() == null;
            if(!condicao2 && !condicao3 && !condicao4){
                this.livros.add(livro);
            }
        }
    }
    public void removerLivroPorTitulo(String titulo){

        Livro lv = livros.stream().filter(x -> x.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
        livros.remove(lv);
    }
    public Livro buscarLivroPorTitulo(String titulo){

        Livro livro = livros.stream().filter(x -> x.getTitulo().equalsIgnoreCase(titulo))
                                     .findFirst()
                                     .orElse(null);
        return livro;
    }
    public Integer contarLivros(){

        return this.livros.size();
    }
    public List<Livro> obterLivrosAteAno(Integer ano){

        List<Livro> x = new ArrayList<>();
        for(Livro i : livros){
            if(i.getDataPublicacao().isBefore(LocalDate.of((ano + 1), 1, 1))){
                x.add(i);
            }
        }
        return x;
    }

    public List<Livro> retornarTopCincoLivros(){

        return livros.stream().sorted(Comparator.comparing(Livro::calcularMediaAvaliacoes).reversed()).limit(5).toList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

