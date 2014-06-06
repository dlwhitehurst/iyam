package com.dlw.webapp.services.impl;

import org.apache.tapestry5.ValueEncoder;
import com.dlw.model.Role;
import com.dlw.service.RoleManager;


public class RoleEncoder implements ValueEncoder<Role> {

    private RoleManager roleManager;

    public RoleEncoder(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public String toClient(Role value) {
        return String.valueOf(value.getId());
    }

    public Role toValue(String clientValue) {
        // happens when testing with iBatis for some reason
        if ("null".equals(clientValue)) {
            return null;
        }

        Long id = Long.valueOf(clientValue);
        return roleManager.get(id);
    }

}
