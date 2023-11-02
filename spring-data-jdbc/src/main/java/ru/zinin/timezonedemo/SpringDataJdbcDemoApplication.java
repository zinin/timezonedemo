package ru.zinin.timezonedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zinin.timezonedemo.service.TestService;

import java.time.ZoneId;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class SpringDataJdbcDemoApplication implements CommandLineRunner {
	@Autowired
	private TestService testService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TimeZone timeZone = TimeZone.getDefault();
		ZoneId zoneId = ZoneId.systemDefault();

		log.info("Default timeZone: {}", timeZone);
		log.info("Default zoneId: {}", zoneId);

		log.info("Adding row...");
		testService.addRow();
		log.info("Done.");
	}
}
