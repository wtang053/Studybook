package com.hhs.studybook.dao;

import com.hhs.studybook.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.username = ?1")
    List<Student> findByUserName(String userName);
}
