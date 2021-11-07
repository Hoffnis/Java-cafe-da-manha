package Contol;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Da;
import Model.Native;

@WebServlet(urlPatterns = { "/Controladore", "/main", "/insert", "/select", "/update", "/delete" })
public class Controladore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Da da = new Da();
	Native nat = new Native();

	public Controladore() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			Cafel(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void Cafel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Native> lista = da.listarcontatos();

		request.setAttribute("cafe", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cafee.jsp");
		rd.forward(request, response);

	}

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		nat.setNome(request.getParameter("nome"));
		nat.setCpf(request.getParameter("cpf"));
		nat.setComida(request.getParameter("comida"));

		da.inserirdados(nat);
		response.sendRedirect("index.html");

	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = request.getParameter("cpf");
		nat.setCpf(cpf);
		da.selecionarContato(nat);

		request.setAttribute("cpf", nat.getCpf());
		request.setAttribute("nome", nat.getNome());
		request.setAttribute("comida", nat.getComida());
		request.setAttribute("idade", nat.getIdade());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");

	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		nat.setCpf(request.getParameter("cpf"));
		nat.setNome(request.getParameter("nome"));
		nat.setComida(request.getParameter("comida"));
		nat.setIdade(request.getParameter("idade"));

		da.alterarContato(nat);

		response.sendRedirect("main");
	}
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		nat.setCpf(cpf);
		
		da.deletarContato(nat);
		response.sendRedirect("main");
		
		
	}
	

}
