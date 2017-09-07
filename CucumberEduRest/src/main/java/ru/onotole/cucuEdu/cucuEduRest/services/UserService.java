package ru.onotole.cucuEdu.cucuEduRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onotole.cucuEdu.cucuEduRest.entities.DefaultParams;
import ru.onotole.cucuEdu.cucuEduRest.entities.Operation;
import ru.onotole.cucuEdu.cucuEduRest.entities.User;
import ru.onotole.cucuEdu.cucuEduRest.entities.Users;

@Service
public class UserService {

    @Autowired
    private Users users;

    @Autowired
    private DefaultParams defaultParams;

    public User createUser(String userName, Boolean vip, Integer initialSum) {
        if (initialSum == null) {
            initialSum = defaultParams.getInitialSum();
        }
        users.create(userName, vip, initialSum);

        return users.get(userName);
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public User performOperation(String userName, Operation operation) {
        if (users.get(userName) == null) {
            throw new IllegalArgumentException("User " + userName + " not found!");
        }
        return users.get(userName).performOperation(operation);
    }
}
