package web.atm.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.atm.dto.LogueoDTO;
import web.atm.entity.Cliente;
import web.atm.model.ClienteDAO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClienteDAO cliDAO = null;
	Cliente cli = null;
	HttpSession sess = null;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		sess = request.getSession();
		sess.invalidate();
		request.setAttribute("mensaje", "Iniciar sesión");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String parametro = request.getParameter("parameter");
		cliDAO = new ClienteDAO();
		cli = new Cliente();
		
		
		sess = request.getSession();
		
		switch (parametro) {
		case "logueo":
		try {
			

		/*String entrada = request.getParameter("info");
		System.out.println(entrada);	
		Gson gson =new Gson();
		LogueoDTO usr = gson.fromJson(entrada, LogueoDTO.class);
		System.out.println(usr);*/
		
		LogueoDTO usr = new LogueoDTO();
		
		
		usr.setUsuario(request.getParameter("Username"));
		usr.setPassword(request.getParameter("Password"));
		
		cli=cliDAO.logueoCliente(usr);
		
		/*String respuesta = gson.toJson(cliDAO);
		System.out.println(respuesta);
		response.getWriter().append(respuesta);*/



		Optional<Cliente> usper = session(cli);
		if (usper.isPresent()) {

			sess.setAttribute("usr", usper.get());
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("views/home.jsp");
			rd.forward(request, response);
			//response.sendRedirect("views/welcome.jsp");

		} else {
			response.sendRedirect("error.jsp");
		}
		
		}catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
		
		break;
		
		
		case "cerrar":
			
			sess = request.getSession();
			sess.invalidate();
			request.setAttribute("mensaje", "Iniciar sesión");
			request.getRequestDispatcher("index.jsp").forward(request, response);

			
			break;
	}
}
		
	
	//request.getSession().invalidate();

	private Optional<Cliente> session(Cliente clnper) {
		// PersonaDAO pdao = per;
		Optional<Cliente> person = null;
		try {
			if (clnper != null) {
				person = Optional.of(clnper);
			} else {
				person = Optional.of(null);
			}

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
		return person;
	}

}
