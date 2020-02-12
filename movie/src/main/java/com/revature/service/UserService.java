package com.revature.service;

import com.revature.dtos.Credentials;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.BadRequestException;
import com.revature.models.AppUser;
import com.revature.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    Set<AppUser>users = new HashSet<>();
    private int id;

   {


        users.add(new AppUser(1,"hoangle.com","hoangle","hoangle", UserRole.ADMIN));
        users.add(new AppUser(2,"hoangle.com1","hoangle1","hoangle1", UserRole.BASIC_USER));
        users.add(new AppUser(3,"hoangle.com2","hoangle2","hoangle2", UserRole.DEV));
        users.add(new AppUser(4,"hoangle.com3","hoangle3","hoangle3", UserRole.LOCKED));


    }

    public Set<AppUser> getAll(){
        return users;
    }

    public AppUser getById(int id){

       return users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(RuntimeException::new);

    }

    public AppUser register(AppUser newUser){
       newUser.setId(++id);
       newUser.setRole(UserRole.BASIC_USER);
       users.add(newUser);
        return newUser;
    }

    public AppUser authenticate(Credentials creds) {
       if (creds == null || creds.getUsername() == null || creds.getPassword() == null){
           throw new BadRequestException();
       }
        return users.stream().filter(u -> {
            return u.getUsername().equals(creds.getUsername()) && u.getPassword().equals(creds.getPassword());
        }).findFirst().orElseThrow(AuthenticationException::new);
    }
}
