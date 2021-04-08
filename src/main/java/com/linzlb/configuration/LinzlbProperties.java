package com.linzlb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Mysql属性配置文件
 * @author linzlb
 */
@Component //作为组件，方便其他地方注入
@PropertySource(value = "classpath:linzlb.properties") //当配置文件不是在application而是在自己定义的其他文件中的时候
@ConfigurationProperties(prefix="linzlbproperties")	//与配置文件的属性前缀对应
public class LinzlbProperties {
	
	private String x;
	private String y;
	private String z;
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
}
