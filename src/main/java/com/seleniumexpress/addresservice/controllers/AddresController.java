package com.seleniumexpress.addresservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.addresservice.response.AddressResponse;
import com.seleniumexpress.addresservice.service.AddressService;

@RestController
public class AddresController {

	/*
	 * @GetMapping("/address") public String getAddress() { return
	 * "Mohan Prasad RB Lake road, MarathHalli Bangalore"; }
	 */

	@Autowired
	private AddressService addressService;

	@GetMapping("/address/{employeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeId") int id) {
		AddressResponse addressResponse = addressService.findAddessByEmployeeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
}
