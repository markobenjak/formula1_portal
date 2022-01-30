package com.protal.portal.Responses;

import com.protal.portal.secuirtyImpl.models.Role;
import com.protal.portal.secuirtyImpl.models.User;

import java.util.List;

public class ListRoleResponse {
    private List<Role> roles;


    public ListRoleResponse(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
