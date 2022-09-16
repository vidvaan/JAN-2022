package com.createiq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;
import com.createiq.template.CreateIQTemplate;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private CreateIQTemplate createIQTemplate;

	public void save(Employee employee) {
		createIQTemplate.update("INSERT INTO EMPLOYEE VALUES(?,?,?)",
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsal() });
	}

	public void update(Employee employee) {
		createIQTemplate.update("UPDATE EMPLOYEE SET ENAME = ? ,ESAL = ? WHERE EID = ?",
				new Object[] { employee.getEname(), employee.getEsal(), employee.getEid() });
	}

	public void delete(int eid) {
		createIQTemplate.update("DELETE FROM EMPLOYEE WHERE EID = ?", new Object[] { eid });
	}

}
