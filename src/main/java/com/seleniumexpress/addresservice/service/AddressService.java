package com.seleniumexpress.addresservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.addresservice.entity.Address;
import com.seleniumexpress.addresservice.repo.AddressRepo;
import com.seleniumexpress.addresservice.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private ModelMapper modelMapper;

	public AddressResponse findAddessByEmployeeId(int employeId) {

		System.out.println("Finding address for employe "+employeId);
//		Address address = addressRepo.findAddessByEmployeeId(employeId);
		Address address = addressRepo.findAddessByEmployeeId(employeId);

		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);

		return addressResponse;

	}

}
