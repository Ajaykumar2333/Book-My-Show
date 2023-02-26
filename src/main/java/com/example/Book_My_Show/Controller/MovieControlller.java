package com.example.Book_My_Show.Controller;


import com.example.Book_My_Show.DTO.MovieDto;
import com.example.Book_My_Show.ServiceLayer.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieControlller {

    @Autowired
    MovieService movieService;


    @PostMapping("/addMovie")
    public String addMovie(@RequestBody  MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }

}
