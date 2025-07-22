package com.example.SMTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SMTP.entity.Email;

@Repository

public interface EmailRepo extends JpaRepository<Email, Long>{


}
