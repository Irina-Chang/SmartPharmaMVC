package controller.venda;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.repository.PersistenceConfig;
import model.repository.VendaRepository;
import model.Venda;

/**
 * Servlet implementation class EditarVendaServlet
 */
public class EditarVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_venda = 0;
		Venda venda = null;
		
		try
		{
			id_venda = Integer.parseInt(request.getParameter("id").trim());
			
			VendaRepository repositorio = new VendaRepository();
			
			venda = repositorio.recuperarVendaPorID(id_venda);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		request.setAttribute("venda", venda);
		
		request.setAttribute("tituloPagina", "Editar venda");
		
		request.setAttribute("pathView", "/views/venda/editar.jsp");
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_venda = 0;
		try
		{
			id_venda = Integer.parseInt(request.getParameter("numId"));
			
			Venda v = new Venda();
			
			VendaRepository repositorio = new VendaRepository();
			
			v = repositorio.recuperarVendaPorID(id_venda);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		if(id_venda > 0)
		{	
			VendaRepository repositorio2 = new VendaRepository();
			
			Venda v = new Venda();
			
			v = repositorio2.recuperarVendaPorID(id_venda);
			
//			v.setLocalizacao(request.getParameter("txtBloco"));
			
			repositorio2.atualizar(v);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/venda");
		
		rd.forward(request, response);
	}

}