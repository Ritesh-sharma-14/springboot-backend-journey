package com.project;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;

     private String name;
     private doubke salary;
     private String department;

     public Employee(){}

     public Employee(String name,double salary,String department){
         this.name=name;
         this.salary=salary;
         this.department=department;
     }

 //Getter & Setter

   public int getId{return id;}
  public void setId(int id){this.id=id;}

  public String getName(){return name;}

  public void setName(String name){
    this.name=name;
  }

  public double getSalary(){
     return salary;
  }

  public void setSalary(double salary){
       this.salary=salary;
  }

  public String getDepartment(){
      return department;
  }

  public void setDepartment(String department){
      this.department=department;
  }
}
















  
