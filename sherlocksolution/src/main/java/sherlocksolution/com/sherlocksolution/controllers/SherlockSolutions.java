package sherlocksolution.com.sherlocksolution.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sherlocksolutions")
public class SherlockSolutions {

    @RequestMapping(value="/{s}",method = RequestMethod.GET)
    public String isValid(@PathVariable String s){
        return Logic.Sherlock.isValid(s);
    }
}
