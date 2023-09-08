package ru.proxy.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.proxy.main.util.Direction;
import ru.proxy.main.util.Step;

import java.util.Date;

@Entity
@Table
public class LogRecord {

    @Column()
    private String logId;
    @Column()
    private String CorrelationId;

    @Column()
    private String system;

    @Column()
    private String host;

    @Column()
    private String component;

    @Column()
    private String operation;

    @Column()
    private Direction direction;

    @Column()
    private Step step;

    @Column()
    private Date timestamp;

}
