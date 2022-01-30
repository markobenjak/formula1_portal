package com.protal.portal.Responses;

import com.protal.portal.secuirtyImpl.models.User;

import java.util.List;

public class ListUsersResponse {
    private List<User> users;


    public ListUsersResponse(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
