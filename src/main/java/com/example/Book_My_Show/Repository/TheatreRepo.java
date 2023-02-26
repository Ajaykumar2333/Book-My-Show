package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepo extends JpaRepository<TheatreEntity,Integer> {
}
