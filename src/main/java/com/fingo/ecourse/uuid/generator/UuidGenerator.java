package com.fingo.ecourse.uuid.generator;

import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@UtilityClass
public class UuidGenerator {
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
