package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

/**
 * Servlet implementation class RegistrazioneC
 */
@WebServlet("/RegistrazioneC")
public class RegistrazioneC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserDao udao = new UserDao();
		User bean = new User();		
		
		bean.setNome(request.getParameter("nome"));
		bean.setCognome(request.getParameter("cognome"));
		bean.setCitta(request.getParameter("citta"));
		bean.setEmail(request.getParameter("email"));
		bean.setIndirizzo(request.getParameter("indirizzo"));
		bean.setProvincia(request.getParameter("provincia"));
		bean.setCap(request.getParameter("cap"));
		
		
		try {
			udao.doSave(bean);
			response.sendRedirect("./reg.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./RegistrazioneFallita.jsp");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
