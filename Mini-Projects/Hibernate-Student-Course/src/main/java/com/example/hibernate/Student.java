package com.project;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student{
   @Id
   @GeneratedValue(Strategy=GenerationType.IDENTITY)
   private int id;

   private String name;
   private int id;

  @ManyToMany(cascade=CAscadeType.IDENTITY)
  private int id;

  @ManyToMany(cascade=CascadeType.ALL)
  @JoinTable(
     name="student_courses",
     joinColumns=@JoinColumn(name="student_id");
     inverseJoinColumns=@JoinColumn(name="course_id")
    )
  private Set<Course> courses = new HashSet<>();

  public  Student(){}

  public Student(String name, String email){
     this.name=name;
     this.email=email;
  }

  //Getter & Setter

  public int getId(){return id;}
  public void SetId(int id){this.id=id;}

  public String getName(){return name;}
  public void setName(String name){this.name = name;}

  public String getEmail(){return email;}
  public void setName(String email){ this.email = email;}

  public Set<Courses> getCourses(){return courses;}
  public void setCourses(Set<Course> course){this.courses= courses;}
}




  








  
