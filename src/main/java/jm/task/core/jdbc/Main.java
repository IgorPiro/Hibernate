package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getSessionFactory();
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();


        userDao.saveUser("Иэн", "Кёртис", (byte) 23);
        userDao.saveUser("Алексей", "Перминов", (byte) 24);
        userDao.saveUser("Густав", "Ар", (byte) 21);
        userDao.saveUser("Джеймс", "МакКормик", (byte) 20);

        userDao.removeUserById(3L);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}