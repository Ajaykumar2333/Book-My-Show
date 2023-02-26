package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
}
