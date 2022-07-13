package controller.laboratorio;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

 
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityTransaction;


import model.repository.Repository;
import model.repository.LaboratorioRepository;
import model.repository.PersistenceConfig;
import model.Laboratorio;
import model.repository.MedicamentoRepository;


/**
 * Servlet implementation class CadastrarLaboratorio
 */
@SuppressWarnings("unused")
@WebServlet("/laboratorio/cadastrar")
public class CadastrarLaboratorioServlet extends HttpServlet 
{	private static final long serialVersionUID = 1L;
       
    public CadastrarLaboratorioServlet() 
    {	super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GET: /laboratorio/cadastrar");
		request.setAttribute("tituloPagina", "Cadastro");	
		request.setAttribute("doServidor", true);
		request.setAttribute("pathView", "/views/laboratorio/cadastrar.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Laboratorio l = new Laboratorio();
	
	l.setRazaoSocial(request.getParameter("txtRazaoSocial"));
	
	l.setEndereco(request.getParameter("txtEndereco"));
	
	l.setTelefone(request.getParameter("txtTelefone"));
	
	l.setCNPJ(request.getParameter("txtCNPJ"));

	LaboratorioRepository repositorio = new LaboratorioRepository();
	
	repositorio.criar(l);	
	
	Collection<Laboratorio> laboratorios = repositorio.recuperarLaboratorios();

	request.setAttribute("laboratorios", laboratorios);
	
	request.setAttribute("tituloPagina",
			"Laboratorios Cadastrados");
	
	request.setAttribute("pathView",
			"/views/laboratorio/consultar.jsp");
	
	request.setAttribute("mensagemAlerta", "Laboratorio cadastrado com sucesso!");
	
	jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
	
	rd.forward(request, response);

}

}
