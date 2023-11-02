package ru.zinin.timezonedemo.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zinin.timezonedemo.jpa.service.TestService;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Slf4j
@SpringBootApplication
public class SpringDataJpaDemoApplication implements CommandLineRunner {
    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
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
