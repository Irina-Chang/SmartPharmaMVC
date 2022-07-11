package controller.medicamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicamento;
import model.repository.PersistenceConfig;
import model.repository.MedicamentoRepository;

import java.io.IOException;

/**
 * Servlet implementation class ExcluirMedicamentoServlet
 */
public class ExcluirMedicamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirMedicamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_medicamento = 0;
		Medicamento medicamento = null;
		
		try
		{
			id_medicamento = Integer.parseInt(request.getParameter("id").trim());
			
			MedicamentoRepository repositorio = new MedicamentoRepository();
			
			medicamento = repositorio.recuperarMedicamentoPorID(id_medicamento);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(medicamento == null)
			medicamento = new Medicamento();
		
		request.setAttribute("medicamento", medicamento);
		
		request.setAttribute("tituloPagina", "Excluir Medicamento");
		
		request.setAttribute("pathView", "/views/medicamento/excluir.jsp");
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try
		{
			id = Integer.parseInt(request.getParameter("numId"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(id > 0)
		{	
			MedicamentoRepository repositorio = new MedicamentoRepository();
			
			Medicamento r = repositorio.recuperarMedicamentoPorID(id);
			
			request.setAttribute("mensagemAlerta", "Medicamento excluida com sucesso!");
				
			repositorio.excluirMedicamento(r);
				
			PersistenceConfig.closeEntityManager();
			
		}
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/medicamento");
		
		rd.forward(request, response);
	}

}