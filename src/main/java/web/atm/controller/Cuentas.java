package web.atm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.atm.dto.CuentaDTO;
import web.atm.dto.CuentasDTO;
import web.atm.dto.MovimientosDTO;
import web.atm.entity.Cuenta;
import web.atm.model.CuentaDAO;
import web.atm.model.MovimientoDAO;

@WebServlet("/Cuentas")
public class Cuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cuentas() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MovimientoDAO movdao = new MovimientoDAO();
		CuentaDAO cntDAO = new CuentaDAO();
		ArrayList<Cuenta> listacc = new ArrayList<>();
		Cuenta acc = null;
		String parametro = request.getParameter("parameter");

		switch (parametro) {

		case "insert":
			try {

				String entrada = request.getParameter("datos");
				System.out.println(entrada);
				Gson gson = new Gson();
				// Integer id = Integer.parseInt(entrada);
				Cuenta cnt = gson.fromJson(entrada, Cuenta.class);
				System.out.println(cnt);

				Boolean val = cntDAO.insert(cnt);

				if (val) {
					System.out.println("Insertado");
					response.getWriter().append("succes");
				} else {
					System.out.println("Error");
				}

			} catch (Exception e) {
				e.getStackTrace();
				e.getMessage();
			}

			break;

		case "all":
			try {
				String entrada = request.getParameter("infoid");
				System.out.println(entrada);
				Gson gson = new Gson();
				// Integer id = Integer.parseInt(entrada);
				CuentasDTO idusrtemp = gson.fromJson(entrada, CuentasDTO.class);
				System.out.println(idusrtemp);

				listacc = cntDAO.accountsById(idusrtemp);

				String retorno = gson.toJson(listacc);
				System.out.println(retorno);
				response.getWriter().append(retorno);

			} catch (Exception e) {
				e.getStackTrace();
				e.getMessage();
			}

			break;

		case "one":

			try {
				acc = new Cuenta();
				String entrada = request.getParameter("infoacc");
				System.out.println(entrada);
				Gson gson = new Gson();
				CuentaDTO cnta = gson.fromJson(entrada, CuentaDTO.class);
				acc = cntDAO.accountByNo(cnta);
				System.out.println(acc);
				String retorno = gson.toJson(acc);
				System.out.println(retorno);
				response.getWriter().append(retorno);
			} catch (Exception e) {

			}

			break;

		case "retiro":

			try {
				acc = new Cuenta();
				String entrada = request.getParameter("movretiro");
				System.out.println(entrada);
				Gson gson = new Gson();
				MovimientosDTO mov = gson.fromJson(entrada, MovimientosDTO.class);

				mov = convert(mov);

				if (mov.getTipocnta().equals("CREDITO")) {

					mov = descuento(mov);
					mov.setSaldo(mov.getSaldo() - mov.getMonto());
					System.out.println(mov);
					movdao.upAccSaldo(mov);

				} else {
					mov.setSaldo(mov.getSaldo() - mov.getMonto());
					movdao.upAccSaldo(mov);
					System.out.println(mov);
				}

			} catch (Exception e) {

			}

			break;

		case "deposito":
			try {
				acc = new Cuenta();
				String entrada = request.getParameter("movretiro");
				System.out.println(entrada);
				Gson gson = new Gson();
				MovimientosDTO mov = gson.fromJson(entrada, MovimientosDTO.class);

				mov = convert(mov);
				mov.setSaldo(mov.getSaldo() + mov.getMonto());
				System.out.println(mov);
				movdao.upAccSaldo(mov);

			} catch (Exception e) {

			}

			break;

		default:
		}

	}

	public MovimientosDTO descuento(MovimientosDTO mov) {

		Double comision = 0.10 * mov.getMonto();
		Double saldoDesc = 0.0;
		saldoDesc = mov.getSaldo() - comision;
		mov.setSaldo(saldoDesc);

		return mov;

	}

	public MovimientosDTO convert(MovimientosDTO mov) {

		// monto
		Double undolar = 20.58; // usd a mxn * 20.58
		Double unpeso = 1 / 20.58;// mxn usd * 0.049
		// moendatran /// moneda cueta
		if (mov.getMonedatran().equals("USD") && mov.getMonedacnta().equals("MXN")) {
			// 5 500 100+500 = 600
			mov.setMonto(mov.getMonto() * undolar);
		} else if (mov.getMonedatran().equals("MXN") && mov.getMonedacnta().equals("USD")) {
			// MXN USD 500 50
			mov.setMonto(mov.getMonto() * unpeso);
		} else {
			mov.setMonto(mov.getMonto());
		}

		return mov;
	}

}
