package fr.imie.bank.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class BankAccountDaoSqlJdbcImpl extends AbstractDao implements BankAccountDao {

	@SuppressWarnings("null")
	public BankAccount selectById(int id) throws DALException {
		Connection conn = null; 
		Statement stmt;
		try {
			stmt = conn.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM person");
			if(rs.first())
		        person = new Person(
		          rs.getInt("id"),
		          rs.getString("prenom"),
		          rs.getString("nom"),
		          LocalDate.parse(rs.getString("ddn")),
		          rs.getString("email"), 
		          null
		          );  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public List<BankAccount> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BankAccount data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(BankAccount data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BankAccount> selectByMotCle(String motCle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> findByPersonId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
