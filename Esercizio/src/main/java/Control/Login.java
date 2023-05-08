package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Email;
		
		User user = new User();
		UserDao udao = new UserDao();
		
		Email= request.getParameter("username");
		
		try {
			user = udao.doRetrieveByKey(Email);
			if(user != null && user.getEmail().compareTo("") != 0) {
				
				//response.getWriter().append("nome: " + utente.getNome() + "\ncognome: " + utente.getCognome());
					
						request.getSession().setAttribute("secure", "Utente");
						request.getSession().setAttribute("Utente loggato" , user);       //Per motivi di sicurezza
						response.sendRedirect("./PaginaAccesso.jsp");
			}
			else {
				response.getWriter().append("Utente non registrato");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
