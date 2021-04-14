package com.linzlb.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.linzlb.dto.RequestDto;
import com.linzlb.dto.StudentDto;
import com.linzlb.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.linzlb.service.StudentService;

/**
 * 验证SpringBoot自带的字段验证
 */
@Api(value="学生Controller", tags={"学生接口"})
@RestController
@RequestMapping("/student")
public class StudentController {
 
    @Resource
    private StudentService studentService;
     
    /**
     * 添加学生???
     * 这个地方获取不到如参，点解？？？
     * @param requestDto
     * @return
     */
    @ApiOperation(value = "添加学生", notes = "添加学生")
    @ResponseBody
    @PostMapping(value="/add",consumes = "application/json") //实体前要加@Valid 假如字段验证不通过，信息绑定到后面定义的BindingResult；
    public String add(@Valid RequestDto<StudentDto> requestDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }else{
            StudentDto sd = requestDto.getBody();
            Student student = new Student();
            student.setAge(sd.getAge());
            student.setName(sd.getName());
            studentService.add(student);
            return "添加成功！";
        }
    }
}