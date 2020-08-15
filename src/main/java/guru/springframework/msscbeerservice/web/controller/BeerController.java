package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    /*private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }*/

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId")UUID beerId){

        //TO DO IMPL
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto){
        //TO DO IMPL
        return new ResponseEntity( HttpStatus.CREATED );
    }

    @PutMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId")UUID beerId,@RequestBody BeerDto beerDto){

        //TO DO IMPL
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT )
    public void deleteBeer(@PathVariable("beerId")UUID beerId){
        //TO DO IMPL

    }
}
