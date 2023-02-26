package com.example.Book_My_Show.ServiceLayer;

import com.example.Book_My_Show.DTO.MovieDto;
import com.example.Book_My_Show.Models.MovieEntity;
import com.example.Book_My_Show.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public String addMovie(MovieDto movieDto){
        MovieEntity movie = MovieEntity.builder().movieName(movieDto.getMovieName()).releaseDate(movieDto.getReleaseDate()).duration(movieDto.getDuration()).build();

        try {
            movieRepo.save(movie);
        }catch (Exception e){
            return "Movie Couldn't be added";
        }
        return "Movie Added Succesfully";

    }

//
//    public MovieEntity getMovieBYName(String name){
//
//    }
}
