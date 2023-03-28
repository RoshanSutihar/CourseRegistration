/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lawrence.quiz_server;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registrations")
@CrossOrigin(origins="*")
public class ResponseController {
    
    private ResponseDAO responseDAO;
    public ResponseController(ResponseDAO dao){

        responseDAO = dao;
    }
    @PostMapping
    public String Save(@RequestBody Response response){
         responseDAO.save(response);
        return "Success";

    }
    
}
