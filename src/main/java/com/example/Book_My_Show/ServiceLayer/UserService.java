package com.example.Book_My_Show.ServiceLayer;

import com.example.Book_My_Show.DTO.UserDto;
import com.example.Book_My_Show.Models.UserEntity;
import com.example.Book_My_Show.Repository.UserRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String createUSer(UserDto userDto){
        UserEntity user = UserEntity.builder().name(userDto.getName()).mobileno(userDto.getMobileNo()).build();

        try{
            userRepo.save(user);
        }catch (Exception e){
            return "User couldnt be added";

        }
        return "User Added Succesfully";

    }
}
