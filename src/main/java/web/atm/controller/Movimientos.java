package web.atm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.atm.dto.CuentasDTO;
import web.atm.dto.MovimientosDTO;
import web.atm.entity.Cuenta;
import web.atm.model.MovimientoDAO;


@WebServlet("/Movimientos")
public class Movimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Movimientos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MovimientoDAO movdao = new MovimientoDAO();
		ArrayList<MovimientosDTO> listacc = new ArrayList<>();
		
		try {
			String entrada = request.getParameter("infoid");
			System.out.println(entrada);
			Gson gson = new Gson();
			//Integer id = Integer.parseInt(entrada);
			CuentasDTO idusrtemp = gson.fromJson(entrada,CuentasDTO.class);
			System.out.println(idusrtemp);
			
			
			
			listacc = movdao.selectTransactionByNoCuenta(idusrtemp);
			
			String retorno =gson.toJson(listacc);
			System.out.println(retorno);
			response.getWriter().append(retorno);
			
			}catch (Exception e) {
				e.getStackTrace();
				e.getMessage();
			}
		
	
	}

}
