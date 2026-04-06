package com.example.demo.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	@Query("from Contact c where c.user.id = :userId")
	public Page<Contact> findContactsByUser(@Param("userId") int userId, Pageable pageable);
    

}