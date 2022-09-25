package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cidade;
import model.CidadeDao;
import model.Pacote;
import model.PacoteDao;

/**
 * Servlet implementation class InserirPacoteServlet
 */
@WebServlet("/pacote-inserir")
public class InserirPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_cidade = Integer.parseInt(request.getParameter("id_cidade"));
		int diaria = Integer.parseInt(request.getParameter("diaria"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		boolean cafe_manha = Boolean.parseBoolean(request.getParameter("cafe_manha"));
		
		Pacote pacote = new Pacote();
		
		pacote.setId_cidade(id_cidade);
		pacote.setDiaria(diaria);
		pacote.setPreco(preco);
		pacote.setCafe_manha(cafe_manha);
		
		PacoteDao pacoteDao = new PacoteDao();
		pacoteDao.insert(pacote);
		response.sendRedirect("pacote-lista");
	}

}
