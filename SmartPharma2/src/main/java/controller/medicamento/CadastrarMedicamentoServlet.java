package controller.medicamento;

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
import model.repository.MedicamentoRepository;
import model.repository.PersistenceConfig;
import model.Laboratorio;
import model.Medicamento;

/**
 * Servlet implementation class CadastrarMedicamento
 */
@SuppressWarnings("unused")
@WebServlet("/medicamento/cadastrar")
public class CadastrarMedicamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastrarMedicamentoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GET: /medicamento/cadastrar");
		request.setAttribute("tituloPagina", "Cadastro");
		request.setAttribute("doServidor", true);
		request.setAttribute("pathView", "/views/medicamento/cadastrar.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Medicamento m = new Medicamento();

		m.setNomeMedicamento(request.getParameter("txtMedicamento"));

		m.setPreco(Float.parseFloat(request.getParameter("preco").replace(",", ".")));

		m.setEstoque(request.getParameter("estoque"));

		m.setComponente(request.getParameter("txtComponente"));

		LaboratorioRepository rep = new LaboratorioRepository();

		int idLab = Integer.parseInt(request.getParameter("laboratorio"));

		Laboratorio lab = rep.recuperarLaboratorioPorID(idLab);

		m.setLaboratorio(lab);

		m.setLote(Integer.parseInt(request.getParameter("lote")));

		m.setValidade(request.getParameter("validade"));

		MedicamentoRepository repositorio = new MedicamentoRepository();

		repositorio.criar(m);

		Collection<Medicamento> medicamentos = repositorio.recuperarMedicamentos();

		request.setAttribute("medicamentoCadastrados", medicamentos);

		request.setAttribute("tituloPagina", "Medicamentos Cadastrados");

		request.setAttribute("pathView", "/views/medicamento/consultar.jsp");

		request.setAttribute("mensagemAlerta", "Medicamento cadastrado com sucesso!");

		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");

		rd.forward(request, response);

	}

}