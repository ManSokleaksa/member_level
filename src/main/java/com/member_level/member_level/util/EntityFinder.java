package com.member_level.member_level.util;

import com.member_level.member_level.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public class EntityFinder {
    private static final Logger logger = LoggerFactory.getLogger(EntityFinder.class);

    public static <T> T findById(JpaRepository<T, String> repository, String id, String entityName) {
        logger.info("Attempting to find {} with ID {} in the repository.", entityName, id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("{} not found with ID {}.", entityName, id);
                    return new ResourceNotFoundException(entityName + " not found with id: " + id);
                });
    }
}
