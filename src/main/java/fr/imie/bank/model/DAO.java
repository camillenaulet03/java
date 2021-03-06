package fr.imie.bank.model;

import java.util.List;

public interface DAO<T> {

	public T selectById(int id) throws DALException;
	

	public List<T> selectAll() throws DALException;
	

	public void update(T data) throws DALException;
	

	public void insert(T data) throws DALException;
	

	public void delete(int id) throws DALException;
	

	
	public List<T> selectByMotCle(String motCle) throws DALException;

}
