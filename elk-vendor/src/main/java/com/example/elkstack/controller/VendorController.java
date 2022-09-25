package com.example.elkstack.controller;

import com.example.elkstack.controller.entity.Vendor;
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
@RequestMapping("/vendor")
public class VendorController {

    private static final Logger log = LoggerFactory.getLogger(VendorController.class);

    @GetMapping
    @Operation(summary = "API that return a vendor by idNumber")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found a vendor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Vendor.class)) }),
            @ApiResponse(responseCode = "400", description = "Un error with the request occurred", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    public ResponseEntity<Vendor> getVendor(@RequestParam Long idNumber) {
        log.info("Returning vendor: {}", idNumber);
        Vendor vendor = new Vendor(1L, "Diego Zanetti");

        log.info("Response: {}", vendor);
        return ResponseEntity.ok(vendor);
    }

    @DeleteMapping
    @Operation(summary = "API to delete a vendor in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete with success a vendor"),
            @ApiResponse(responseCode = "400", description = "Un error with the request occurred", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    public ResponseEntity<?> deleteVendor(@RequestParam Long idNumber) {
        log.info("Deleting vendor: {}", idNumber);

        return ResponseEntity.ok(null);
    }
}
