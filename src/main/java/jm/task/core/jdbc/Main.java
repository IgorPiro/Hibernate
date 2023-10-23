package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        List<User> users = new ArrayList<>();
        users.add(new User("Иэн", "Кёртис", (byte) 23));
        users.add(new User("Алексей", "Перминов", (byte) 24));
        users.add(new User("Густав", "Ар", (byte) 21));
        users.add(new User("Джеймс", "МакКормик", (byte) 20));
        for (User us : users) {
            userService.saveUser(us.getName(), us.getLastName(), (byte) us.getAge());
            System.out.println("User с именем – " + us.getName() + " добавлен в базу данных");
        }
        List<User> usersTable = userService.getAllUsers();
        for (User us : usersTable) {
            System.out.println(us);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}