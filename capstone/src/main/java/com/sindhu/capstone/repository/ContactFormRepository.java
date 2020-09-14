package com.sindhu.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sindhu.capstone.model.ContactForm;




@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Long>{

}