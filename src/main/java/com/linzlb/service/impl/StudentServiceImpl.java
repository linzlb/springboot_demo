package com.linzlb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.linzlb.dao.StudentDao;
import com.linzlb.entity.Student;
import com.linzlb.service.StudentService;
 

/**
 * 学生Service实现类
 * @author user
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
 
    @Resource
    private StudentDao studentDao;
 
    @Override
    public void add(Student student) {
        studentDao.save(student);
    }
}
