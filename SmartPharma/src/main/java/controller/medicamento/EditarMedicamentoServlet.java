package controller.medicamento;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicamento;
import model.repository.*;
import java.io.IOException;

/**
 * Servlet implementation class EditarMedicamentoServlet
 */
public class EditarMedicamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarMedicamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
    @Override
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
		
		request.setAttribute("tituloPagina", "Editar Medicamento");
		
		request.setAttribute("pathView", "/views/medicamento/editar.jsp");
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
		
		MedicamentoRepository repositorio = new MedicamentoRepository();
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
			MedicamentoRepository repositorio2 = new MedicamentoRepository();
			
			Medicamento n = new Medicamento();
			
			n = repositorio2.recuperarMedicamentoPorID(id);
			
			n.setNomeMedicamento(request.getParameter("txtNomeMedicamento"));
			
			n.setDataMedicamento(request.getParameter("txtDataMedicamento"));

			repositorio2.atualizar(n);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/medicamento");
		
		rd.forward(request, response);
	}

}