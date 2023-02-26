package com.example.Book_My_Show.Controller;


import com.example.Book_My_Show.DTO.TheatreDto;
import com.example.Book_My_Show.ServiceLayer.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping(value = "/addTheatre")
    public String addTheatre(@RequestBody TheatreDto theatreDto){
        return theatreService.addTheatre(theatreDto);

    }

    //get Theate by theatre id
    //get all thetare
}
