package edu.sjsu.cmpe275.teamproject.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;

import edu.sjsu.cmpe275.teamproject.model.Category;
import edu.sjsu.cmpe275.teamproject.model.Menu;
import edu.sjsu.cmpe275.teamproject.model.Order_details;
import edu.sjsu.cmpe275.teamproject.model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		Order_details ord = new Order_details();
		Set<Order_details> order = new HashSet<Order_details>();  
		Set<Menu> men = new HashSet<Menu>();
		user.setUsername("shikho@gmail.com");
		user.setPassword("shikho");
		Order_details order_details = new Order_details();
		//order_details.setOrder_id(1);
		order_details.setUser(user);
		Order_details order_details1 = new Order_details();
		order_details1.setUser(user);
		//order_details.setOrder_id(1);
		order.add(order_details);
		order.add(order_details1);
		user.setOrder_details(order);
		/*int count = (int) session.createCriteria("Menu").setProjection(Projections.rowCount()).uniqueResult();
		if(count>1000)
			System.out.println("Menu item id is invalid");*/
		Menu menu_items = new Menu();
		Category categ1 = null;
		categ1=Category.Main_course;
		menu_items.setCategory(categ1);
		menu_items.setCalories(6);
		menu_items.setItem_name("Grilled Sandwich");
		menu_items.setMenu_status("active");
		menu_items.setUnitPrice("7");
		menu_items.setPreparation_time(4);
		//menu_items.setCategory("Drinks");
		menu_items.setOrder(ord);
		Menu menu_items1 = new Menu();
		Category categ2 = null;
		categ2=Category.Appetizer;
		menu_items1.setCategory(categ2);
		menu_items1.setCalories(7);
		menu_items1.setItem_name("Orange chicken");
		menu_items1.setMenu_status("active");
		menu_items1.setUnitPrice("9");
		menu_items1.setPreparation_time(6);
		menu_items1.setOrder(ord);
		menu_items.setOrder(ord);
		men.add(menu_items);
		men.add(menu_items1);
		ord.setMenu_items(men);
		session.save(user);
		session.save(ord);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
