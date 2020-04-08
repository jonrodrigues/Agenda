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

@WebServlet("/AdicionarContato.do")
public class AdicionarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capturando o par�metro nome_contato
				String nome = request.getParameter("nome_contato");
				// Capturando o par�metro telefone_contato
				String telefone = request.getParameter("telefone_contato");
				// Capturando o par�metro email_contato
				String email = request.getParameter("email_contato");
				
				// Criando um objeto de sa�da de dados:
				PrintWriter saida = response.getWriter();
				
				/*saida.println("Nome: " + nome + " Telefone: "
						+ telefone + " Email: " + email);*/
				
				// Criando um objeto de sess�o do usu�rio:
				HttpSession sessao = request.getSession();
				// Instanciando um objeto do tipo Contato:
				Contato contato = new Contato(nome, email, telefone);
				
				// Adicionando o objto contato dentro de uma lista:
				ArrayList<Contato> contatos = new ArrayList();
				
				// Adicionando um novo contato:
				contatos.add(contato);
				
				// Adicionando a lista de contatos � sess�o do usu�rio:
				sessao.setAttribute("lista_contatos", contatos);
				
				// Redirecionar o usu�rio para listagem:
				response.sendRedirect("ListaContatos.do");
			}

}
