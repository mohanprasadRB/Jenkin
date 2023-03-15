package com.seleniumexpress.addresservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.seleniumexpress.addresservice.controllers.AddresController;
import com.seleniumexpress.addresservice.entity.Address;
import com.seleniumexpress.addresservice.response.AddressResponse;
import com.seleniumexpress.addresservice.service.AddressService;

@SpringBootTest
public class AddresControllerTest {

	@InjectMocks
	AddresController addresController;
	
	@Mock
	AddressService addressService;
	
	@Test
	void ControllerTest()
	{
		Address address= new Address();
		  address.setLane1("DG ROAD");
		  address.setId(101);
		  address.setLane2("TVK");
		  address.setZip(572227);
		  AddressResponse addressResponse = new AddressResponse();
	      addressResponse.setId(address.getId());
		  addressResponse.setLane1(address.getLane1());
		  addressResponse.setLane2(address.getLane2());
		  addressResponse.setState("KTK");
		  
		  when(addressService.findAddessByEmployeeId(addressResponse.getId())).thenReturn(addressResponse);
		  ResponseEntity<AddressResponse> responseEntity = addresController.getAddressByEmployeeId(addressResponse.getId());
		  assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	
	}
}
