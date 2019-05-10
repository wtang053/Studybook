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

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public ActionResult addStudent(@RequestParam("studentName") String studentName, @RequestParam("studentGender") String studentGender, @RequestParam("studentAge") int studentAge, @RequestParam("studentUsername") String studentUsername, @RequestParam("studentPassword") String studentPassword) {
        Student student1 = new Student(studentName, studentGender, studentAge, studentUsername, studentPassword);
        studentDao.save(student1);
        return ActionResult.genActionResult(ResultCode.ADD_SUCCESS);
    }

    @RequestMapping(value = "/findstudent", method = RequestMethod.POST)
    public ActionResult findStudent(@RequestParam("keyword") String keyword) {
        List<Student> students = studentDao.findByStudentName(keyword);
        if (students == null) {
            return ActionResult.genActionResult(ResultCode.NO_ELEMENT);
        }
        return ActionResult.genActionResult(ResultCode.CODE_OK, students);
    }

    @RequestMapping(value = "/removestudent", method = RequestMethod.POST)
    public ActionResult removeStudent(@RequestParam("id") Integer id) {
        studentDao.deleteById(id);
        return ActionResult.genActionResultByOk();
    }

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

    @RequestMapping(value = "listAllStudents", method = RequestMethod.GET)
    public ActionResult listAllStudents() {
        return ActionResult.genActionResult(ResultCode.CODE_OK, studentDao.findAll());
    }

}
