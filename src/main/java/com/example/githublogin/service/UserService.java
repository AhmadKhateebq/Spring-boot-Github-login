package com.example.githublogin.service;

import com.example.githublogin.controller.dto.UserDto;
import com.example.githublogin.mapper.MapStruct;
import com.example.githublogin.model.User;
import com.example.githublogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    MapStruct mapper = MapStruct.INSTANCE;

    public List<User> findAll() {
        return repository.findAll ().stream ().collect (Collectors.toList ());
    }

    public User findByName(String param) {
        return repository.findByName (param).orElse (new User ());
    }

    public String addUser(UserDto userDto) {
        if(!repository.existsBySocialId (userDto.getSocialId ())){
            System.out.println (userDto);
            User user = mapper.USER_DTO (userDto);
            System.out.println (user);
            repository.save (user);
            return user+"Added";
        }
        else
            return "user exist";

    }





    private boolean exist(String socialId){
        for (User user : repository.findAll ()) {
            if(user.getSocialId ().equals (socialId))
                return true;
        }
        return false;
    }
}


