package controller.medicamento;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicamento;
import model.Receita;
import model.repository.MedicamentoRepository;
import model.repository.PersistenceConfig;
import model.repository.ReceitaRepository;

import java.io.IOException;
import java.util.Collection;


/**
 * Servlet implementation class ConsultarMedicamentosServlet
 */
@SuppressWarnings("unused")
@WebServlet({"/medicamento", "/medicamento/consultar" })
public class ConsultarMedicamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarMedicamentosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
    MedicamentoRepository repositorio = new MedicamentoRepository();
		
		Collection<Medicamento> medicamentos = repositorio.recuperarMedicamentos();
		
		request.setAttribute("medicamentoCadastrados", medicamentos);
		request.setAttribute("tituloPagina", "Medicamentos");	
		request.setAttribute("doServidor", true);
		request.setAttribute("pathView", "/views/medicamento/consultar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

