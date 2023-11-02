package ru.zinin.timezonedemo.r2dbc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.zinin.timezonedemo.r2dbc.model.TestEntity;

import java.util.UUID;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Repository
public interface TestEntityRepository extends ReactiveCrudRepository<TestEntity, UUID> {
}
