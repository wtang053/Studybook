package com.hhs.studybook.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_student")
@EntityListeners(AuditingEntityListener.class)
public class Student implements Serializable, Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "student_name", nullable = false, length = 255)
    private String studentName;

    @Column(name = "student_gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "student_age", nullable = false)
    private Integer age;
    
    @Column(name = "student_username", nullable = false, length = 400)
    private String username;
    
    @Column(name = "student_password", nullable = false, length = 400) 
    private String password;

    public Student() {
    }

    public Student(String studentName, String gender, Integer age) {
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.username = "";
        this.password = "";
    }
    
    public Student(String studentName, String gender, Integer age, String username, String password) {
    	this.studentName = studentName;
    	this.gender = gender;
    	this.age = age;
    	this.username = username;
    	this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public void changePassword(String password) {
    	this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return this.getId() - student.getId();
    }
}
