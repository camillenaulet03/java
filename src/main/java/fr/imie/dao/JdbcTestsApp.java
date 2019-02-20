package fr.imie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JdbcTestsApp {
	private static final String SQL_INSERT="INSERT INTO `person`(`id`,`prenom`,`nom`,`ddn`,`email`) VALUES (NULL,?,?,?,?);";
	private static final String SQL_INSERT1="INSERT INTO `bankaccount`(`id`,`number`) VALUES (NULL,?);";
	public static void main(String[] args) throws DALException, SQLException {


		Statement stmtSelect = null;

		try {
			int id = 7;
			ResultSet rs = null;
			PreparedStatement stmt=null;
			PreparedStatement stmt1=null;
			Connection connexion =null;
			try {
			    connexion = JdbcTools.getConnection();
				stmt = connexion.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, "Camille");
				stmt.setString(2, "Naulet");
				stmt.setObject(3, "03.01.2010");
				stmt.setString(4, "camille.naulet@imie.fr");
				stmt.executeUpdate();
				stmt1 = connexion.prepareStatement(SQL_INSERT1,Statement.RETURN_GENERATED_KEYS);
				stmt1.setInt(1, 987);
				stmt1.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DALException("selectById failed - id = " + id, e);
			}
			finally {
				try {
					if (rs != null){
						rs.close();
					}
					if (stmt != null){
						stmt.close();
					}
					if(connexion!=null){
						connexion.close();
					}
				} catch (SQLException e) {
					throw new DALException("Close failed", e);
				}
			}
		}finally{
			try {
				if(stmtSelect!=null){
					stmtSelect.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
