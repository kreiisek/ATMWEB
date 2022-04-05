package web.atm.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.atm.dto.PersonasDTO;
import web.atm.dto.UsuariosDTO;
import web.atm.model.ClienteDAO;
import web.atm.model.PersonaDAO;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO cliDAO = null;
	PersonaDAO perDao = null;

	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametro = request.getParameter("parameter");
		cliDAO = new ClienteDAO();
		perDao = new PersonaDAO();
		// UsuariosDTO ustemp = new UsuariosDTO();
		Gson gson = new Gson();
		try {

			switch (parametro) {

			case "insert":
				// Lo puedo simplificar con GSON
				// con gson pasamos los parametroscompletos sin ir unoporuno

				String entrada = request.getParameter("info");
				System.out.println(entrada);
				UsuariosDTO ustemp = gson.fromJson(entrada, UsuariosDTO.class);
				System.out.println(ustemp);

				/*
				 * sin gson recaudando una por uno
				 * ustemp.setNombre(request.getParameter("nombre"));
				 * ustemp.setApPaterno(request.getParameter("appaterno"));
				 * ustemp.setApMaterno(request.getParameter("apmaterno"));
				 * ustemp.setEdad(request.getParameter("edad"));
				 * ustemp.setUsuario(request.getParameter("usuario"));
				 * ustemp.setPassword(request.getParameter("contra"));
				 */

				Boolean val = cliDAO.Insert(ustemp);

				if (val) {
					
				System.out.println("Insertado");
				} else {
					System.out.println("Error");
				}

				break;

			case "search":
				
				String entra = request.getParameter("infoid");
				System.out.println(entra);
				PersonasDTO idper = gson.fromJson(entra, PersonasDTO.class);
				PersonasDTO pertem = new PersonasDTO();
				pertem = perDao.search(idper);
				System.out.println(pertem);
				String retorno = gson.toJson(pertem);
				System.out.println(retorno);
				response.getWriter().append(retorno);

				break;

			case "update":
				
				String inpout = request.getParameter("infoup");
				System.out.println(inpout);
				PersonasDTO ustemp2 = gson.fromJson(inpout, PersonasDTO.class);
				System.out.println(ustemp2);
				
				Boolean valid = perDao.update(ustemp2);

				if (valid) {
				System.out.println("Actualizado");
				} else {
					System.out.println("Error");
				}
				
				
				break;
				
				
				default:
		

			}

		} catch (Exception e) {

		}

	}
}
