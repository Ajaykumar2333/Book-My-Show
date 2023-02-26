package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.DTO.ShowDto;
import com.example.Book_My_Show.ServiceLayer.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public String addShow(@RequestBody() ShowDto showDto){
        return showService.addShow(showDto);

    }
}
