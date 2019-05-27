package com.hhs.studybook.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_elective")
@EntityListeners(AuditingEntityListener.class)
public class ElectiveChatRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Integer id;

    @Column(name = "chat_date")
    private String date;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "chat_text")
    private String text;

    public ElectiveChatRoom() {
    }

    ;

    /**
     * Elective Chat Room
     *
     * @param date      Time a user sends a text
     * @param studentId Student ID
     * @param text      Input Strings in the chat room
     */
    public ElectiveChatRoom(String date, Integer studentId, String text) {
        this.date = date;
        this.studentId = studentId;
        this.text = text;
    }

    /**
     * Get the ID
     * @return the ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set an ID
     * @param id an ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the date sending a text
     * @return the date sending a text
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the date sending a text
     * @param date the date sending a text
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the student ID
     * @return the student ID
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Set the student ID
     * @param studentId the student ID
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Get the input text by a user
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Set a input text by a user
     * @param text a text
     */
    public void setText(String text) {
        this.text = text;
    }
}
