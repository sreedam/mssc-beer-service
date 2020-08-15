package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeer() throws  Exception{
        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception{
        BeerDto beerDto = BeerDto.builder().build();;
        String beerDtojson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtojson)).andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception{
        BeerDto beerDto = BeerDto.builder().build();;
        String beerDtojson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtojson)).andExpect(status().isNoContent());
    }

    @Test
    void deleteBeer() throws Exception{
        BeerDto beerDto = BeerDto.builder().build();;
        String beerDtojson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(delete("/api/v1/beer/"+ UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtojson)).andExpect(status().isNoContent());
    }
}