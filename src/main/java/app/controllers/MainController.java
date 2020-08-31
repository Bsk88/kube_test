package app.controllers;

import app.service.requerst.RestServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private RestServiceRequest restServiceRequest;

    @RequestMapping(value = "/get", method = RequestMethod.GET,  produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
    public ResponseEntity<String> get() {

        String response = restServiceRequest.getName(String.class);

        return new ResponseEntity<>("Вызван метод сервиса '"+response+"'", HttpStatus.OK);
    }



}
