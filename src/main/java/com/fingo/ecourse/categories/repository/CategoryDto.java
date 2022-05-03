package com.fingo.ecourse.categories.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
	String name;
	UUID uuid;
}
