package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
