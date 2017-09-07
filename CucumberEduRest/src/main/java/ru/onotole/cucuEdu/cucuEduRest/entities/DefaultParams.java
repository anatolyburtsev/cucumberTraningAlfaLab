package ru.onotole.cucuEdu.cucuEduRest.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "default_params")
public class DefaultParams {
    private Integer initialSum;
}
