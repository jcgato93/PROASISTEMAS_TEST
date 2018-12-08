package NonDivisibleSubset.com.NonDivisible.controllers;

import NonDivisibleSubset.com.NonDivisible.DTO.NonDivisibleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class NonDivisibleController {

    @RequestMapping(value="/nondivisible",method = RequestMethod.POST)
    public ResponseEntity<String> nonDivisible(@Valid @RequestBody NonDivisibleDTO nonDivisibleDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return  new ResponseEntity("{'statuscode': 400, 'message':'BAD_REQUEST', 'data':null}", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok()
                .body("{'statuscode': 200, 'message':'Success', 'data':"+Logic.NonDivisible.nonDivisibleSubset(nonDivisibleDTO.k,nonDivisibleDTO.S)+"}" ) ;
    }

}
