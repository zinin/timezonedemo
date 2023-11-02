package ru.zinin.timezonedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zinin.timezonedemo.model.TestEntity;

import java.util.UUID;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Repository
public interface TestEntityRepository extends CrudRepository<TestEntity, UUID> {
}
