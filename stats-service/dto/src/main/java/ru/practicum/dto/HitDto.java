package ru.practicum.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class HitDto {

    private Long id;

    @NotBlank(message = "app it cannot consist only of spaces.")
    private String app;

    @NotBlank(message = "uri it cannot consist only of spaces.")
    private String uri;

    @NotBlank(message = "ip it cannot consist only of spaces.")
    private String ip;

    @NotBlank(message = "timestamp it cannot consist only of spaces.")
    private String timestamp;
}