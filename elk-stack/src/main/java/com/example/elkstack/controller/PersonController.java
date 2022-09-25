package com.example.elkstack.controller;

import com.example.elkstack.controller.entity.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @GetMapping
    @Operation(summary = "API that return a person by idNumber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found a person", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400", description = "Un error with the request occurred", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    public ResponseEntity<Person> getPerson(@RequestParam Long idNumber) {
        log.info("Returning person: {}", idNumber);
        Person person = new Person(1L, "Diego Zanetti");

        log.info("Response: {}", person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping
    @Operation(summary = "API to delete a person in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete with success a person"),
            @ApiResponse(responseCode = "400", description = "Un error with the request occurred", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    public ResponseEntity<?> deletePerson(@RequestParam Long idNumber) {
        log.info("Deleting person: {}", idNumber);

        return ResponseEntity.ok(null);
    }
}
