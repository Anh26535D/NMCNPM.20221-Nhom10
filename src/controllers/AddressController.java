package controllers;

import java.util.List;

import services.AddressService;

public class AddressController {

	AddressService addrService = new AddressService();
	
	public List<String> searchByWard(String key){
       return addrService.searchByWard(key);
	}
	
	public List<String> searchByDistrict(String key){
	    return addrService.searchByDistrict(key);
	}
	
	public List<String> searchByProvince(String key){
	    return addrService.searchByProvince(key);
	}
}
