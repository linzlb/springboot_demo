package com.linzlb.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/17 14:19
 * @Function:
 */
@Data
public class StudentDto implements Serializable {
    @Pattern(regexp = "\\w+\\d+",message = "名字需要符合\\w+\\d+的规则")
    @Column(length=50)
    private String name;

    @NotNull(message="年龄不能为空！")
    @Min(value=18,message="年龄必须大于18岁！")
    @Column(length=50)
    private Integer age;
}