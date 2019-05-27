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
public class Student implements Serializable {

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


    /**
     * A student object with name, gender, and age stored.
     *
     * @param studentName name of the student
     */
    public Student(String studentName, String gender, Integer age) {
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.username = "";
        this.password = "";

    }


    /**
     * A student object with username and password included
     *
     * @param studentName Name of the student
     * @param gender      Gender of the student
     * @param age         Age of the student
     * @param username    the student's username
     * @param password    the student's password
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
     *
     * @return the ID of the student. Every student has its unique ID, even though it is not shown to the user.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Change the student's ID
     *
     * @param id The student's ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get a student's name
     *
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Change a student's name
     *
     * @param studentName the student's name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get the student's gender
     *
     * @return the gender of the student
     */
    public String getGender() {
        return gender;
    }

    /**
     * Change the student's gender
     *
     * @param gender the student's gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get the age of the student
     *
     * @return The age of the student
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Change the age of the student
     *
     * @param age The age of the student
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get the student's username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set a username
     *
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
     *
     * @param password you know that
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Change the password
     *
     * @param password the new password
     */
    public void changePassword(String password) {
        this.password = password;
    }

    /**
     * String type of a student object
     *
     * @return Information of a student, including ID, student name, gender, and age.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
