package com.zs.service;

import java.util.List;

import com.zs.entity.Client;

public interface ClientService {

	void add(Client c);
	
	Client get(int cid);
	
	List<Client> list();
}
