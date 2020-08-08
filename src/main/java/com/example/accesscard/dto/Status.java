package com.example.accesscard.dto;

import lombok.Getter;

import java.util.stream.Stream;

public enum Status {
    INACTIVE(0),
    ACTIVE(1);

    @Getter
    int statusCode;
    Status(int statusCode){
        this.statusCode = statusCode;
    }

    public static Status getByStatusCode(int status){
        return Stream.of(Status.values())
                .filter(s -> s.statusCode == status)
                .findAny()
                .orElseThrow( () -> new IllegalArgumentException("Invalid status code"));

    }
}
