package br.edu.ifpe.recife.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.recife.model.entities.Livro;
import br.edu.ifpe.recife.model.repositories.LivroRepository;

/**
 * Servlet implementation class LivrosServlet
 */
//@WebServlet(name = "LivrosServlet", urlPatterns ={"/LivrosServlet"})

@WebServlet("/LivrosServlet")
public class LivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LivrosServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	List<Livro> livros=LivroRepository.readAll();
    	
    	response.setContentType("text/html;charset=UTF-8");
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
            out.println("<tr><th>titulo</th><th>autor<th><th>edicao</th><th>editora</th><th>genero</th><th>Operações</th></tr>");
            
            for(Livro l : livros){
                out.println("<tr>"
                        + "<td>"+l.getTitulo()+"</td>"
                        + "<td>"+l.getAutor()+"<td>"
                        + "<td>"+l.getEdicao()+"</td>"
                        + "<td>"+l.getEditora()+"</td>"
                        + "<td>"+l.getGenero()+"</td>"
                        +"<td><a href='VisualizaLivroServlet?titulo="+l.getTitulo()+"' >"+"Visualizar></a></td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
            
    	}
    	
  

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String edicao = request.getParameter("edicao");
        int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
        int quantPaginas = Integer.parseInt(request.getParameter("quantPaginas"));
        String editora = request.getParameter("editora");
        String genero = request.getParameter("genero");
        
        Livro l = new Livro();
        
    	l.setTitulo(titulo);
    	l.setAutor(autor);
    	l.setEdicao(edicao);
    	l.setAnoPublicacao(anoPublicacao);
    	l.setQuantPaginas(quantPaginas);
    	l.setEditora(editora);
    	l.setGenero(genero);
    	
    	LivroRepository.insert(l);
    	
    	response.setContentType("text/html;charset=UTF-8");
    	
    	try (PrintWriter out = response.getWriter()) {
    	out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LivrosServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>O Livro "+titulo+" foi cadastrado com sucesso!</h1>");
        out.println("</body>");
        out.println("</html>");
    	}
        	
        	
	}

}
