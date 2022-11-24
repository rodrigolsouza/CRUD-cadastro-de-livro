package br.edu.ifpe.recife.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.recife.model.entities.Livro;
import br.edu.ifpe.recife.model.repositories.LivroRepository;

/**
 * Servlet implementation class VisualizaLivroServlet
 */
@WebServlet("/VisualizaLivroServlet")
public class VisualizaLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String titulo= request.getParameter("titulo");
		
		Livro livro=LivroRepository.read(titulo);
		try (PrintWriter out = response.getWriter()){
    		out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LivrosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Livros Cadastrados!</h1>");
            out.println("<a href=\"index.html\">home</a><br/>");
            out.println("<table border=\"1\">");

            out.println("<tr><th>Titulo</th><td>"+livro.getTitulo()+"</td></tr>");
            out.println("<tr><th>Autor</th><td>"+livro.getAutor()+"</td></tr>");
            out.println("<tr><th>Edicao</th><td>"+livro.getEdicao()+"</td></tr>");
            out.println("<tr><th>Ano de Publicação</th><td>"+livro.getAnoPublicacao()+"</td></tr>");
            out.println("<tr><th>quatidade de Paginas</th><td>"+livro.getQuantPaginas()+"</td></tr>");
            out.println("<tr><th>Editora</th><td>"+livro.getEditora()+"</td></tr>");
            out.println("<tr><th>Genero</th><td>"+livro.getGenero()+"</td></tr>");
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
		}
		
	}
}


