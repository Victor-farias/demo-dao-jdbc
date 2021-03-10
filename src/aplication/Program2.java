package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: department find by id ===");
		
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department find all ===");
		
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: department insert ===");
		
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(1);
		department.setName("PCs");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete by id ===");
		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
