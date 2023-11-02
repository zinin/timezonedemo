package ru.zinin.timezonedemo.r2dbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import ru.zinin.timezonedemo.r2dbc.model.TestEntity;
import ru.zinin.timezonedemo.r2dbc.service.TestService;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Slf4j
@SpringBootApplication
public class SpringDataR2dbcDemoApplication implements CommandLineRunner {
    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataR2dbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = ZoneId.systemDefault();

        log.info("Default timeZone: {}", timeZone);
        log.info("Default zoneId: {}", zoneId);

        log.info("Adding row...");
        Mono<TestEntity> mono = testService.addRow();
        mono.block();
        log.info("Done.");
    }
}
