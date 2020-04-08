package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Contato;

@WebServlet("/ListaContatos.do")
public class ListaContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// Acessando a sessão do usuário:
		HttpSession sessao = request.getSession();
		
		// Lendo os valores da sessão:
		ArrayList<Contato> contatos = (ArrayList)
			sessao.getAttribute("lista_contatos"); // Object
		
		// Instanciar um objeto de saída:
		PrintWriter saida = response.getWriter();
		
		// Listar os contatos dentro da lista de contatos:
		for(Contato c : contatos) {
			saida.println(
					"Nome: " + c.getNome()
					+ " Telefone: " + c.getTelefone()
					+ " E-mail: " + c.getTelefone()
					);
		}
		
	}

}








