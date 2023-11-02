package ru.zinin.timezonedemo.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Configuration
public class ClockConfiguration {
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
