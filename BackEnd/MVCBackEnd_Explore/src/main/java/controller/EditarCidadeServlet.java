package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cidade;
import model.CidadeDao;

/**
 * Servlet implementation class EditarCidadeServlet
 */
@WebServlet("/cidade-editar")
public class EditarCidadeServlet extends HttpServlet {
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
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.selectById(id);
		request.setAttribute("cidade", cidade);
		request.getRequestDispatcher("editar_cidade.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
		String continente = request.getParameter("continente");
		
		Cidade cidade = new Cidade();
		cidade.setId(id);
		
		cidade.setNome(nome);
		cidade.setEstado(estado);
		cidade.setPais(pais);
		cidade.setContinente(continente);
		
		CidadeDao cidadeDao = new CidadeDao();
		cidadeDao.updateById(cidade);
		response.sendRedirect("cidade-lista");
	}

}
