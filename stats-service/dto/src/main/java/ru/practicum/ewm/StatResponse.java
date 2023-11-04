package ru.practicum.ewm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class StatResponse {

    private String app;

    private String uri;

    private Long hits;

}
