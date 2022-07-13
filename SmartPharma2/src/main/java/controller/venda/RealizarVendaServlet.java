package controller.venda;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Venda;
import model.repository.VendaRepository;
import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class RealizarVenda
 */
@WebServlet({ "/venda/realizar" })
public class RealizarVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarVendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("tituloPagina", "Cadastrar nova venda");
		
		request.setAttribute("pathView", "/views/venda/realizar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Venda v = new Venda();
		
//		v.setNome(request.getParameter("txtNome"));

		VendaRepository repositorio2 = new VendaRepository();
		
		repositorio2.criar(v);
		
		Collection<Venda> vendas = repositorio2.recuperarVendas();
	
		request.setAttribute("vendas", vendas);
		
		request.setAttribute("tituloPagina", "Vendas Realizadas");
		
		request.setAttribute("pathView", "/views/venda/listar.jsp");
		
		request.setAttribute("mensagemAlerta", "Venda cadastrada com sucesso!");
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
		
	}

}