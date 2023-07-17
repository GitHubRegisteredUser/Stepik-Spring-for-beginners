package HibernateOneToManyBi;

import HibernateOneToManyBi.Entity.Department;
import HibernateOneToManyBi.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Department dep = new Department("Sales", 200, 1000);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Mariya", "Sidorova", 700);
//            Employee emp3 = new Employee("Stepan", "Smirnov", 600);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//***************************************************************************
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class, 3);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0);
            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            System.out.println("Done!");
//***************************************************************************
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//***************************************************************************
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 2);
//            session.delete(employee);
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }

}
