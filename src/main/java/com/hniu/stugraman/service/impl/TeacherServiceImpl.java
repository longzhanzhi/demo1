package com.hniu.stugraman.service.impl;

import com.hniu.stugraman.dao.ITeacherDao;
import com.hniu.stugraman.dao.impl.TeacherDaoImpl;
import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    ITeacherDao dao = new TeacherDaoImpl();

@Override
public void updateTea(Teacher teacher) {
    dao.updateTea(teacher);
}

    @Override
    public Teacher getTeById(int id) {
        return dao.getTeById(id);
    }

    @Override
        public List<Student> findAllScore() {
        List<Student> students = dao.findStudent();
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            List<EScore> score = dao.findScore(student.getId());
            student.setScores(score);
            studentList.add(student);
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
        return studentList;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students = dao.findStudent();
        return students;
    }

    @Override
    public Teacher findOne(User user) {
        return dao.findOne(user);
    }


}
