package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class UserDao
{
	private static final String TABLE_NAME = "utente";
	
	public synchronized  void doSave(User user) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UserDao.TABLE_NAME
					+ " (email, nome, cognome, indirizzo, provincia, cap, citta)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		try
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getNome());
			preparedStatement.setString(3, user.getCognome());
			preparedStatement.setString(4, user.getIndirizzo());
			preparedStatement.setString(5, user.getProvincia());			
			preparedStatement.setString(6, user.getCap());
			preparedStatement.setString(7, user.getCitta());
			
			preparedStatement.executeUpdate();

			connection.commit(); //Salva le modifiche sul database
		} 
		finally 
		{
			try 
			{
				if (preparedStatement != null)
					preparedStatement.close();
			} 
			finally 
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}
	
public synchronized void doUpdate (User var, String vecchia_mail) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String upsql = "UPDATE " + UserDao.TABLE_NAME + 
						" SET email = ?, password = ?, nome = ?, cognome = ?, codice_fiscale = ? " + 
						"WHERE (email = ?) ";
		try 
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(upsql);
			
			preparedStatement.setString(1, var.getEmail());
			preparedStatement.setString(2, var.getNome());
			preparedStatement.setString(3, var.getCognome());
			preparedStatement.setString(4, var.getIndirizzo());
			preparedStatement.setString(5, var.getCitta());
			preparedStatement.setString(6, var.getProvincia());
			preparedStatement.setString(7, var.getCap());
			preparedStatement.setString(8, vecchia_mail);		// per sapere quale mail cambiare tenendo come riferimento quella vecchia durante la modifica
			
			preparedStatement.executeUpdate();
			

		} 
		finally 
		{
			try 
			{
				if (preparedStatement != null)
					preparedStatement.close();
			} 
			finally 
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}
	
	
	public synchronized User doRetrieveByKey(String Email) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		User bean = null;
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?";

		try 
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, Email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) 
			{
				bean = new User();
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setCap(rs.getString("cap"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
			}

		} 
		finally 
		{
			try 
			{
				if (preparedStatement != null)
					preparedStatement.close();
			} 
			finally 
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return bean;
	}

	public synchronized boolean doDelete(String Email) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + UserDao.TABLE_NAME + " WHERE email = ?";

		try 
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, Email);

			result = preparedStatement.executeUpdate();

		}
		finally 
		{
			try 
			{
				if (preparedStatement != null)
					preparedStatement.close();
			} 
			finally 
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	public synchronized Collection<User> doRetrieveAll(String order) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<User> users = new LinkedList<User>();
		
		String selectSQL = "SELECT * FROM " + UserDao.TABLE_NAME;

		if (order != null && !order.equals("")) 
		{
			selectSQL += " ORDER BY " + order;
		}

		try 
		{
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) 
			{
				User bean = new User();

				
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setCap(rs.getString("cap"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
				users.add(bean);
			}

		} 
		finally 
		{
			try 
			{
				if (preparedStatement != null)
					preparedStatement.close();
			} 
			finally 
			{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return users;
	}
	}