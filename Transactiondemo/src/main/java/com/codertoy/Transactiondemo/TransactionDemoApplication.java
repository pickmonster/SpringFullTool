package com.codertoy.Transactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @description:
 * @author: WuNan
 * @version:2020/1/3
 * @Copyright(C): 2019 by CoderToy
 */
@Slf4j
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@SpringBootApplication
public class TransactionDemoApplication implements CommandLineRunner {
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private FooService fooService;

	public static void main(String[] args) {
		SpringApplication.run(TransactionDemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		log.info("COUNT BEFORE TRANSACTION: {}", getCount());
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//			@Override
//			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//				jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'abc')");
//				log.info("COUNT IN TRANSACTION: {}", getCount());
//				transactionStatus.setRollbackOnly();
//			}
//		});
//		log.info("COUNT AFTER TRANSACTION: {}", getCount());
//	}

	@Override
	public void run(String... args) throws Exception {
		fooService.insertRecord();
		log.info("AAA: {}",
				jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
		try {
			fooService.insertThenRollback();
		} catch (Exception e) {
			log.info("BBB: {}",
					jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
		}

		try {
			fooService.invokeInsertThenRollback();
		} catch (Exception e) {
			log.info("BBB: {}",
					jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
		}
	}

	private long getCount() {
		return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM FOO")
				.get(0).get("CNT");
	}
}
