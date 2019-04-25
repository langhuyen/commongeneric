package misa.sme.example.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.beanutils.BeanUtils;

public class ResultSetMapper<T> {
	public List<T> mapRersultSetToObject(ResultSet rs, Class outputClass) throws IllegalArgumentException, NoSuchMethodException, SecurityException {
		List<T> outputList = null;
		try {
			// make sure resultset is not null
			if (rs != null) {
				// check if outputClass has 'Entity' annotation
				if (outputClass.isAnnotationPresent(Model.class)) {
					// get the resultset metadata
					ResultSetMetaData rsmd = rs.getMetaData();
					// get all the attributes of outputClass
					Field[] fields = outputClass.getDeclaredFields();
					while (rs.next()) {
					//Khởi tạo đối tượng 
						T bean = (T) outputClass.newInstance();
						
							for (Field field : fields) {
								field.setAccessible(true);
//								Duyệt qua các trường của đối tượng xem những trường nào được map
								if (field.isAnnotationPresent(Col.class)) {
									Col column = field.getAnnotation(Col.class);
									//lấy giá trị của trường đó
									String value=rs.getString(field.getName().toLowerCase());
								field.set(bean, field.getType().getConstructor(String.class).newInstance(value));
								}
							
						}
						if (outputList == null) {
							outputList = new ArrayList<T>();
						}
						outputList.add(bean);
					}

				} else {
					// throw some error
				}
			} else {
				return null;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return outputList;
	}

}
