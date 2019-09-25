package com.mellisphera.repositories;

import com.mellisphera.entities.log.LogEvents;
import com.mellisphera.entities.log.LogType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepoitory extends MongoRepository<LogEvents, String> {

    public List<LogEvents> findByLogType(LogType logType);
}
