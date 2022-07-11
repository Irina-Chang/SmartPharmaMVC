package controller.receita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.repository.ReceitaRepository;
import model.repository.PersistenceConfig;
import model.Receita;
import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ConsultarReceitasServlet
 */
@WebServlet({"/receita", "/receita/consultar"})
public class ConsultarReceitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarReceitasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		request.setAttribute("receitas", "receitas");
		
		request.setAttribute("tituloPagina", "Receitas Cadastradas");
		
		request.setAttribute("pathView", "/views/receita/consultar.jsp");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
ReceitaRepository repositorio = new ReceitaRepository();
		
		Collection<Receita> receitas = repositorio.recuperarReceitas();
		
		PersistenceConfig.closeEntityManager();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}