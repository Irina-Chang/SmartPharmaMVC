package controller.receita;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import model.Receita;
import model.repository.ReceitaRepository;
import model.repository.PersistenceConfig;

/**
 * Servlet implementation class CadastrarReceita
 */

@WebServlet("/receita/cadastrar")
public class CadastrarReceitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarReceitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("tituloPagina", "Cadastrar Receitas");
		request.setAttribute("doServidor", true);
		request.setAttribute("pathView", "/views/receita/cadastrar.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");		
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Receita r = new Receita();
		
        ReceitaRepository repositorio = new ReceitaRepository();
		
        repositorio.criar(r);
		
        Collection<Receita> receitas = repositorio.recuperarReceitas();
		
        
		
        request.setAttribute("receitas", receitas);
		
        request.setAttribute("tituloPagina", "Receitas Cadastradas");
		
        request.setAttribute("pathView", "views/receita/consultar.jsp");
		
        request.setAttribute("mensagemAlerta", "Receita cadastrada com sucesso!");
		
        jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
        rDispatcher.forward(request, response);
		
	}

}