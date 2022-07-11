package controller.venda;

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
 * Servlet implementation class ExcluirVendaServlet
 */
public class ExcluirVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirVendaServlet() {
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
		
		if(venda == null)
			venda = new Venda();
		
		request.setAttribute("venda", venda);
		
		request.setAttribute("tituloPagina", "Excluir Venda");
		
		request.setAttribute("pathView", "/views/venda/excluir.jsp");
		
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
			VendaRepository repositorio = new VendaRepository();
			
			Venda r = repositorio.recuperarVendaPorID(id);
			
			request.setAttribute("mensagemAlerta", "Dados da venda excluidos com sucesso!");
				
			repositorio.excluirVenda(r);
				
			PersistenceConfig.closeEntityManager();
			
		}
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/venda");
		
		rd.forward(request, response);
	}

}