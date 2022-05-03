package com.fingo.ecourse.uuid.generator;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UuidGenerator {
	public UUID generateId() {
		return UUID.randomUUID();
	}
}
