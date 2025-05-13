package com.internship_Management.internship.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Internship")
public class InternshipController {


   @GetMapping
   public String GetAllInternships (){
    return "Internship1 \n Internship2 \n Internship3 ";
   }
}
