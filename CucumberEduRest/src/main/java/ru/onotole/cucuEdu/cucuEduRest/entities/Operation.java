package ru.onotole.cucuEdu.cucuEduRest.entities;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Operation {

    @NotNull
    private Integer value;

    @Pattern(regexp = "[+-]")
    private String operation;

}
