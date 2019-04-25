package misa.sme.example.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDaoImp<ID extends Serializable,T> implements GenericDao<ID, T> {

	
	@Autowired
	Connection connectionDatabase;
	
	protected Class<T> persistentClass;
	
	public AbstractDaoImp(){
		/*
		 * Lay doi so thu hai la T(class)
		 */
		this.persistentClass=(Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	public String getPersistentClassName() {
		/*
		 * Convert tuwf class==>string
		 */
		return persistentClass.getSimpleName();
	}
	
	
	@Override
	public List<T> findAll() {
		/*
		 * Lay ten cua ham
		 */
		StringBuilder sql=new StringBuilder("select * from ");
		sql.append(getPersistentClassName());
		PreparedStatement pre=null;
		List<T> lst=new ArrayList<T>();
		try {
			pre=connectionDatabase.prepareStatement(sql.toString());
			ResultSet resultSet = pre.executeQuery();
			ResultSetMapper<T> resultSetMapper=new ResultSetMapper<>();
			lst=resultSetMapper.mapRersultSetToObject(resultSet,persistentClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pre.close();
			connectionDatabase.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lst;
	}

}
