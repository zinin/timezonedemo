package ru.zinin.timezonedemo.r2dbc.service;

import reactor.core.publisher.Mono;
import ru.zinin.timezonedemo.r2dbc.model.TestEntity;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
public interface TestService {
    Mono<TestEntity> addRow();
}
