package controller.receita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.repository.PersistenceConfig;
import model.repository.ReceitaRepository;
import model.Receita;

/**
 * Servlet implementation class ExcluirReceitaServlet
 */
public class ExcluirReceitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirReceitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_receita = 0;
		Receita receita = null;
		
		try
		{
			id_receita = Integer.parseInt(request.getParameter("id").trim());
			
			ReceitaRepository repositorio = new ReceitaRepository();
			
			receita = repositorio.recuperarReceitaPorID(id_receita);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(receita == null)
			receita = new Receita();
		
		request.setAttribute("receita", receita);
		
		request.setAttribute("tituloPagina", "Excluir Receita");
		
		request.setAttribute("pathView", "/views/receita/excluir.jsp");
		
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
			ReceitaRepository repositorio = new ReceitaRepository();
			
			Receita r = repositorio.recuperarReceitaPorID(id);
			
			request.setAttribute("mensagemAlerta", "Receita excluida com sucesso!");
				
			repositorio.excluirReceita(r);
				
			PersistenceConfig.closeEntityManager();
			
		}
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/receita");
		
		rd.forward(request, response);
	}

}