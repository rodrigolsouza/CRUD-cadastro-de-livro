package br.edu.ifpe.recife.model.repositories;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.recife.model.entities.Livro;

public class LivroRepository {
	
	private static List<Livro> livros= new ArrayList<>();
	
	public static void insert(Livro l){
		livros.add(l);
	}
	
	public static void update(Livro l){
		for(Livro lAux:livros) {
			if (lAux.getTitulo().equals(l.getTitulo())) {
				lAux.setAutor(l.getAutor());
				lAux.setEdicao(l.getEdicao());
				lAux.setAnoPublicacao(l.getAnoPublicacao());
				lAux.setQuantPaginas(l.getQuantPaginas());
				lAux.setEditora(l.getEditora());
				lAux.setGenero(l.getGenero());
			}
		}
	}
	
	public static Livro read(String titulo){
		for(Livro lAux:livros) {
			if(lAux.getTitulo().equals(titulo)) {
				return lAux;
			}
		}
		return null;
	}
	
	public static void delete(Livro l){
		for(Livro lAux:livros) {
			if(lAux.getTitulo().equals(l.getTitulo())) {
				livros.remove(lAux);
			}
		}
	}
	
	public static List<Livro> readAll(){
		return livros;
	}
}
