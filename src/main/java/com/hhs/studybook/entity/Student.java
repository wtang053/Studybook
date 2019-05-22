package com.hhs.studybook.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Default student object
 */
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

    @Column(name = "student_class1", nullable = true, length = 30)
    private String class1;

    @Column(name = "student_class2", nullable = true, length = 30)
    private String class2;

    @Column(name = "student_class3", nullable = true, length = 30)
    private String class3;

    @Column(name = "student_class4", nullable = true, length = 30)
    private String class4;

    @Column(name = "student_class5", nullable = true, length = 30)
    private String class5;

    @Column(name = "student_class6", nullable = true, length = 30)
    private String class6;

    @Column(name = "student_class7", nullable = true, length = 30)
    private String class7;

    public Student() {
    }


    /**
     * A student object with name, gender, and age stored.
     *
     * @param studentName name of the student
     * @param gender      gender of the student
     * @param age         age of the student
     */
    public Student(String studentName, String gender, Integer age, String class1, String class2, String class3, String class4, String class5, String class6, String class7) {
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.username = "";
        this.password = "";
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.class4 = class4;
        this.class5 = class5;
        this.class6 = class6;
        this.class7 = class7;
    }

    /**
     * A student object with username and password included
     * @param studentName Name of the student
     * @param gender Gender of the student
     * @param age Age of the student
     * @param username the student's username
     * @param password the student's password
     */
    public Student(String studentName, String gender, Integer age, String username, String password) {
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    /**
     * Return the student's ID
     * @return the ID of the student. Every student has its unique ID, even though it is not shown to the user.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Change the student's ID
     * @param id The student's ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get a student's name
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Change a student's name
     * @param studentName the student's name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get the student's gender
     * @return the gender of the student
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * Change the student's gender
     * @param gender the student's gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * Get the age of the student
     * @return The age of the student
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Change the age of the student
     * @param age The age of the student
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get the student's username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set a username
     * @param username the student's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password
     *
     * @return the current password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set a password
     * @param password you know that
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Change the password
     * @param password the new password
     */
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

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3;
    }

    public String getClass4() {
        return class4;
    }

    public void setClass4(String class4) {
        this.class4 = class4;
    }

    public String getClass5() {
        return class5;
    }

    public void setClass5(String class5) {
        this.class5 = class5;
    }

    public String getClass6() {
        return class6;
    }

    public void setClass6(String class6) {
        this.class6 = class6;
    }

    public String getClass7() {
        return class7;
    }

    public void setClass7(String class7) {
        this.class7 = class7;
    }

    /**
     * Compare the students' ID. Return 0 if the ID matches.
     * @param o the other student
     * @return the numerical difference of the students' ID
     */
    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return this.getId() - student.getId();
    }
}
