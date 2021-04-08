package com.linzlb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="t_student")
@Data
public class Student {
 
    @Id
    @GeneratedValue
    private Integer id;
     
    @Pattern(regexp = "\\w+\\d+",message = "名字需要符合\\w+\\d+的规则")
    @Column(length=50)
    private String name;
     
    @NotNull(message="年龄不能为空！")
    @Min(value=18,message="年龄必须大于18岁！")
    @Column(length=50)
    private Integer age;
     
}