package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findByMovieName(String movieName);//manually we have to write this
}
