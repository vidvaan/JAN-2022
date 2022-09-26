package com.createiq.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.createiq.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void save(Employee employee) {
		hibernateTemplate.save(employee);

	}

	public void update(Employee employee) {
		hibernateTemplate.update(employee);

	}

	public void deleteById(Integer eid) {
		Employee employee = new Employee();
		employee.setEid(eid);
		hibernateTemplate.delete(employee);
	}

	public List<Employee> findAll() {
		return (List<Employee>) hibernateTemplate.find("from Employee");
	}

}
