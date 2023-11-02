package ru.zinin.timezonedemo.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
public class TestEntity implements Persistable<UUID> {
    @EqualsAndHashCode.Include
    @Id
    private UUID id;

    @Column(value = "local_date_time_with_tz_col")
    private LocalDateTime localDateTimeWithTZ;
    @Column(value = "instant_with_tz_col")
    private Instant instantWithTZ;
    @Column(value = "offset_date_time_with_tz_col")
    private OffsetDateTime offsetDateTimeWithTZ;

    @Column(value = "local_date_time_without_tz_col")
    private LocalDateTime localDateTimeWithoutTZ;
    @Column(value = "instant_without_tz_col")
    private Instant instantWithoutTZ;
    @Column(value = "offset_date_time_without_tz_col")
    private OffsetDateTime offsetDateTimeWithoutTZ;

    @Override
    public boolean isNew() {
        return true;
    }
}
