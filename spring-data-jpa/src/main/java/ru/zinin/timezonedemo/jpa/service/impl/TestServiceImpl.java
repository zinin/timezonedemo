package ru.zinin.timezonedemo.jpa.service.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zinin.timezonedemo.jpa.model.TestEntity;
import ru.zinin.timezonedemo.jpa.service.TestService;

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
    private final EntityManager entityManager;
    private final Clock clock;

    @Transactional
    @Override
    public void addRow() {
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

        entityManager.persist(testEntity);
    }
}
