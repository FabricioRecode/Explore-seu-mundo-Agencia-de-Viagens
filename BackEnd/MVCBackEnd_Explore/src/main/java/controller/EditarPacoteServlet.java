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
 * Servlet implementation class EditarPacoteServlet
 */
@WebServlet("/pacote-editar")
public class EditarPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PacoteDao pacoteDao = new PacoteDao();
		Pacote pacote = pacoteDao.selectById(id);
		request.setAttribute("pacote", pacote);
		request.getRequestDispatcher("editar_pacote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int id_cidade = Integer.parseInt(request.getParameter("id_cidade"));
		int diaria = Integer.parseInt(request.getParameter("diaria"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		boolean cafe_manha = Boolean.parseBoolean(request.getParameter("cafe_manha"));
		
		Pacote pacote = new Pacote();
		pacote.setId(id);
		pacote.setId_cidade(id_cidade);
		pacote.setDiaria(diaria);
		pacote.setPreco(preco);
		pacote.setCafe_manha(cafe_manha);
		
		PacoteDao pacoteDao = new PacoteDao();
		pacoteDao.updateById(pacote);
		response.sendRedirect("pacote-lista");
		
	}

}
