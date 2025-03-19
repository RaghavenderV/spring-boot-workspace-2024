package com.vodapally.service;

import com.vodapally.security.Secured;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Secured(roles = {"ADMIN"})
    public String adminOnlyMethod(){
        return "This is an admin-only method.";
    }

    @Secured(roles = {"USER","ADMIN"})
    public String userOrAdminMethod(){
        return "This method is accessible to users and admins.";
    }

    public String publicMethod(){
        return "This is a public method.";
    }
}
