package com.fariga.service;

import com.fariga.entity.User;
import com.fariga.data.Storage;

import java.util.LinkedList;
import java.util.List;

public class UserService {

/*//OLD VERSION
    private static Storage storage;
    private static List<User> list = new LinkedList<>();

    public UserService(Storage storage1) {
        storage = storage1;
    }

    *//*public UserService() {
        storage.initialList();
    }
*//*

    public List<User> getListOfUsers() {
        list = storage.listOfUsers();
        return list;
    }

    public boolean check(String username, String password) {
        list = getListOfUsers();
        for (User u : list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String updateLoginStatus(String user) {
        list = getListOfUsers();
        for (User u : list) {
            if (u.getUsername().equals(user)) {
                u.setStatus("logged-in");
                return u.getStatus();
            }
        }
        return "status not changed";
    }


    public boolean checkingUsernameInList(String username) {
        list = getListOfUsers();
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }*/


    private Storage storage;

    public UserService(Storage storage) {
        this.storage = storage;
    }

    public List<User> getListOfUsers() {
        return storage.listOfUsers();
    }

    public boolean check(String username, String password) {
        for (User u : getListOfUsers()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkingUsernameInList(String username) {
        for (User u : getListOfUsers()) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public boolean updateLoginStatus(String user) {
        for (User u : getListOfUsers()) {
            if (u.getUsername().equals(user)) {
                u.setStatus("logged-in");
                return true;
            }
        }
        return false;
    }
}
