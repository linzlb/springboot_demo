package com.linzlb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linzlb.entity.Student;;
/**
 * 学生Dao接口
 * @author user
 *
 */
public interface StudentDao extends JpaRepository<Student, Integer>{
 
}
