package com.codertoy.druidDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Stream;

//@SpringBootApplication
@Slf4j
public class DruidDemoApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	public static void main(String[] args) {
//		SpringApplication.run(DruidDemoApplication.class, args);
//	}

	@Override
	public void run(String... args) throws Exception {
		log.info(dataSource.toString());
		_printBeanInfo();
	}

	private void _printBeanInfo() {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
			Stream.of(beanInfo.getPropertyDescriptors())
					.forEach(propertyDescriptor -> {
						System.out.println(propertyDescriptor);
					});
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}

}
