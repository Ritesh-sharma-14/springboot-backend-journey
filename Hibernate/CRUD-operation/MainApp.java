package com.project;
import prg.hibernate.Session;
import prg.hibernate.Transaction;

public class MainApp{
     public  static void main(String[] args){
          Session session=HibernateUtil.getFactory().openSession();
          Transaction tx=session.beginTransaction();

          //CREATE
          Employee e1=new Employee("Ramesh", 5000,"IT");
          session.save(e1);

          //READ
         Employee emp=session.get(Employee.class,1);
         System.out.println(emp.getName());

         //UPDATE
         emp.setSalary(60000);
         session.update(emp);

         //DELETE
         session.delete(emp);

         tx.commit();
         session.close();
         System.out.println("CRUD OPERATION DONE");
     }
}