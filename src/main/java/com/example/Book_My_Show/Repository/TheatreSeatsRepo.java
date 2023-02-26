package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatsRepo extends JpaRepository<TheatreSeatEntity,Integer> {
}
