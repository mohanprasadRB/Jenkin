package com.seleniumexpress.addresservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.seleniumexpress.addresservice.entity.Address;
import com.seleniumexpress.addresservice.repo.AddressRepo;
import com.seleniumexpress.addresservice.response.AddressResponse;
import com.seleniumexpress.addresservice.service.AddressService;

@SpringBootTest
class AddresServiceApplicationTests {

	@Test
	void contextLoads() {
	}
//	AddressControllerTest
 
	@Mock
	AddressRepo addressRepo;
	
	@InjectMocks
	AddressService addressService;
	
	@Spy
	ModelMapper modelMapper;
	
	public List<Address> alist = new ArrayList<Address>();
	
	AddressResponse addressResponse = new AddressResponse(); 
	
	@Test
	void check()
	{
		Address address= new Address();
		  address.setLane1("DG ROAD");
		  address.setId(101);
		  address.setLane2("TVK");
		  address.setZip(572227);
		  addressResponse.setId(address.getId());
		  addressResponse.setLane1(address.getLane1());
		  addressResponse.setLane2(address.getLane2());
		  addressResponse.setState("KTK");
		  
		  when(addressRepo.findAddessByEmployeeId(address.getId())).thenReturn(address);
		  when(modelMapper.map(Address.class, AddressResponse.class)).thenReturn(addressResponse);
		  addressService.findAddessByEmployeeId(address.getId());
		  assertEquals("DG ROAD",addressService.findAddessByEmployeeId(addressResponse.getId()).getLane1());
		 
	}
	

}
