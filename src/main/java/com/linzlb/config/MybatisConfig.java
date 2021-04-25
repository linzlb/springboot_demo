package com.linzlb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/25 14:51
 * @Function:
 */
@Configurable
@MapperScan("com.linzlb.mapper")
public class MybatisConfig {

}
