package com.ciq.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ciq.model.Employee;
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Employee employee) {
         hibernateTemplate.save(employee);	
	}

	@Override
	public void update(Employee employee) {
		hibernateTemplate.update(employee);
		
	}

	@Override
	public void deleteById(Integer eid) {
		Employee employee = new Employee();
		employee.setEid(eid);
		hibernateTemplate.delete(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		return hibernateTemplate.get(Employee.class, eid);
	}

	@Override
	public List<Employee> findAll() {
		return hibernateTemplate.loadAll(Employee.class);
	}
	

}
