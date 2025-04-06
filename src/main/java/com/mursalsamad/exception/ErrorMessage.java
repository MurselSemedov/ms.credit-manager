package com.mursalsamad.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {

    NO_DATA_FOUND("Not found customer with %s"),
    UNEXPECTED_ERROR("Unexpected error occurred");

    private final String message;
}