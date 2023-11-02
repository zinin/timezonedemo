package ru.zinin.timezonedemo.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Date: 02.11.2023
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "test_entity", schema = "public")
@Entity
public class TestEntity {
    @EqualsAndHashCode.Include
    @Id
    private UUID id;

    @Column(name = "local_date_time_with_tz_col")
    private LocalDateTime localDateTimeWithTZ;
    @Column(name = "instant_with_tz_col")
    private Instant instantWithTZ;
    @Column(name = "offset_date_time_with_tz_col")
    private OffsetDateTime offsetDateTimeWithTZ;

    @Column(name = "local_date_time_without_tz_col")
    private LocalDateTime localDateTimeWithoutTZ;
    @Column(name = "instant_without_tz_col")
    private Instant instantWithoutTZ;
    @Column(name = "offset_date_time_without_tz_col")
    private OffsetDateTime offsetDateTimeWithoutTZ;
}
