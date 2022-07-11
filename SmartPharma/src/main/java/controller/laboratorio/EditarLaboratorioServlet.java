
package controller.laboratorio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Laboratorio;
import model.repository.PersistenceConfig;
import model.repository.LaboratorioRepository;

import java.io.IOException;

/**
 * Servlet implementation class EditarLaboratorioServlet
 */
public class EditarLaboratorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarLaboratorioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_laboratorio = 0;
		Laboratorio laboratorio = null;
		
		try
		{
			id_laboratorio = Integer.parseInt(request.getParameter("id").trim());
			
			LaboratorioRepository repositorio = new LaboratorioRepository();
			
			laboratorio = repositorio.recuperarLaboratorioPorID(id_laboratorio);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(laboratorio == null)
			laboratorio = new Laboratorio();
		
		request.setAttribute("laboratorio", laboratorio);
		
		request.setAttribute("tituloPagina", "Editar Laboratorio");
		
		request.setAttribute("pathView", "/views/laboratorio/editar.jsp");
		
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
		
		/*	if(id > 0)
		{	
			LaboratorioRepository repositorio2 = new LaboratorioRepository();
			
			Laboratorio n = new Laboratorio();
			
			n = repositorio2.recuperarLaboratorioPorID(id);
			
			n.setNomeMedicamento(request.getParameter("txtNomeMedicamento"));
			
			n.setDataLaboratorio(request.getParameter("txtDataLaboratorio"));

			repositorio2.atualizar(n);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/laboratorio");
		
		rd.forward(request, response);*/
	}

}
