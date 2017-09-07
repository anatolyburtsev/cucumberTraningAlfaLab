package ru.onotole.cucuEdu.cucuEduRest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private Integer money;
    private Boolean isVip;

    public User performOperation(Operation operation) {
        if (operation.getOperation().equals("+")) {
            money += operation.getValue();
        } else if (operation.getOperation().equals("-")) {
            if (money - operation.getValue() < 0) {
                throw new IllegalStateException("Not enough money!");
            } else {
                money -= operation.getValue();
            }
        }
        return this;
    }

}
