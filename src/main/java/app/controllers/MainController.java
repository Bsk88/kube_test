package app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/get", method = RequestMethod.GET,  produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("Get Method", HttpStatus.OK);
    }



}
