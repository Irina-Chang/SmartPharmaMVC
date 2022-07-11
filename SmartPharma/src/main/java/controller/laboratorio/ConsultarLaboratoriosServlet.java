package controller.laboratorio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laboratorio;

import model.repository.LaboratorioRepository;
import model.repository.PersistenceConfig;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ConsultarLaboratoriosServlet
 */
@WebServlet({ "/laboratorio" })
public class ConsultarLaboratoriosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarLaboratoriosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LaboratorioRepository repositorio = new LaboratorioRepository();

		Collection<Laboratorio> laboratorios = repositorio.recuperarLaboratorios();
		
		request.setAttribute("laboratorios", laboratorios);
		
		request.setAttribute("tituloPagina", "Laboratorios");
		request.setAttribute("doServidor", true);
		request.setAttribute("pathPagina","/views/laboratorio/consultar.jsp");
		request.setAttribute("pathView", "/views/laboratorio/consultar.jsp");
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		

		rd.forward(request, response);
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

