package com.hhs.studybook.controller;

import com.hhs.studybook.dao.StudentDao;
import com.hhs.studybook.entity.Student;
import com.hhs.studybook.util.ActionResult;
import com.hhs.studybook.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    /**
     * Add a student, including his information, into the server.
     *
     * @param studentName     Name of the student
     * @param studentGender   Gender of the student
     * @param studentAge      Age of the student
     * @param studentUsername Username of the student
     * @param studentPassword Password of the student
     * @param class1          1st class the student takes
     * @param class2          2nd class the student takes
     * @return
     */
    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public ActionResult addStudent(@RequestParam("studentName") String studentName, @RequestParam("studentGender") String studentGender, @RequestParam("studentAge") int studentAge, @RequestParam("studentUsername") String studentUsername, @RequestParam("studentPassword") String studentPassword, @RequestParam("studentClass1") String class1, @RequestParam("studentClass2") String class2) {
        Student student1 = new Student(studentName, studentGender, studentAge, studentUsername, studentPassword, class1, class2);
        studentDao.save(student1);
        return ActionResult.genActionResult(ResultCode.ADD_SUCCESS);
    }

    /**
     * Find a student based on the keyword typed in
     * @param keyword The student's name
     * @return a student object with the same name
     */
    @RequestMapping(value = "/findstudent", method = RequestMethod.POST)
    public ActionResult findStudent(@RequestParam("keyword") String keyword) {
        List<Student> students = studentDao.findByStudentName(keyword);
        if (students == null) {
            return ActionResult.genActionResult(ResultCode.NO_ELEMENT);
        }
        return ActionResult.genActionResult(ResultCode.CODE_OK, students);
    }

    /**
     * Remove a student permanently from the database
     * @param id The student's id (id is unique)
     * @return The removed student with the same id
     */
    @RequestMapping(value = "/removestudent", method = RequestMethod.POST)
    public ActionResult removeStudent(@RequestParam("id") Integer id) {
        studentDao.deleteById(id);
        return ActionResult.genActionResultByOk();
    }

    /**
     * Change a student's information
     * @param id The student's id
     * @param studentName the student's name
     * @param studentGender the student's gender
     * @param studentAge the student's age
     * @param studentUsername the student's username
     * @param studentPassword the student's password
     * @return The fixed student's information
     */
    @RequestMapping(value = "/editstudent", method = RequestMethod.POST)
    public ActionResult editStudent(@RequestParam("id") Integer id,
                                    @RequestParam("studentName") String studentName,
                                    @RequestParam("studentGender") String studentGender,
                                    @RequestParam("studentAge") Integer studentAge,
                                    @RequestParam("studentUsername") String studentUsername,
                                    @RequestParam("studentPassword") String studentPassword){
        Optional<Student> optStudent = studentDao.findById(id);
        if (optStudent.isPresent()) {
            Student student = optStudent.get();
            student.setStudentName(studentName);
            student.setGender(studentGender);
            student.setAge(studentAge);
            student.setUsername(studentUsername);
            student.setPassword(studentPassword);

            studentDao.saveAndFlush(student);
            return ActionResult.genActionResultByOk();
        }
        return ActionResult.genActionResult(ResultCode.NO_ELEMENT);
    }

    /**
     * List all the students in the database, including their information
     * @return students' all information
     */
    @RequestMapping(value = "listAllStudents", method = RequestMethod.GET)
    public ActionResult listAllStudents() {
        return ActionResult.genActionResult(ResultCode.CODE_OK, studentDao.findAll());
    }

}
