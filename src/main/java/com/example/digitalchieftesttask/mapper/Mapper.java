package com.example.digitalchieftesttask.mapper;

public interface Mapper<T, R> {

    T mapToEntity(R object);
    R mapToDto(T object);
}
