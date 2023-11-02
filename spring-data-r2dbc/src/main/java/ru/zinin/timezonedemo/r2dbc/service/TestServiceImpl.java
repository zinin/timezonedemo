package ru.zinin.timezonedemo.r2dbc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.zinin.timezonedemo.r2dbc.model.TestEntity;
import ru.zinin.timezonedemo.r2dbc.repository.TestEntityRepository;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestEntityRepository repository;
    private final Clock clock;

    @Transactional
    @Override
    public Mono<TestEntity> addRow() {
        Instant nowInstant = Instant.now(clock);
        LocalDateTime nowLocalDateTime = LocalDateTime.ofInstant(nowInstant, ZoneId.systemDefault());
        OffsetDateTime nowOffsetDateTime = OffsetDateTime.ofInstant(nowInstant, ZoneId.systemDefault());

        TestEntity testEntity = TestEntity.builder()
                .id(UUID.randomUUID())
                .localDateTimeWithTZ(nowLocalDateTime)
                .instantWithTZ(nowInstant)
                .offsetDateTimeWithTZ(nowOffsetDateTime)
                .localDateTimeWithoutTZ(nowLocalDateTime)
                .instantWithoutTZ(nowInstant)
                .offsetDateTimeWithoutTZ(nowOffsetDateTime)
                .build();

        return repository.save(testEntity);
    }
}
