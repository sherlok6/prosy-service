package ru.proxy.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.proxy.main.entity.LogRecord;

@Repository
public interface LogRepository extends JpaRepository<LogRecord, Long> {
    void saveLogRecord(LogRecord record);
}
