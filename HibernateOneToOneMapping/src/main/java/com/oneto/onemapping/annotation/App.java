package com.oneto.onemapping.annotation;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();

		employee.setName("izhar");

		Address address = new Address();
		address.setCity("mumbai");
		address.setCountry("india");
		address.setCode(40072);
		address.setState("maharashtra");
		address.setEmployee(employee);

		employee.setAddress(address);

		Serializable save = session.save(address);
		System.out.println(save);

		Serializable save2 = session.save(employee);
		System.out.println(save2);

		transaction.commit();

		System.out.println("Hello World!");

		session.close();

		factory.close();
	}
}
