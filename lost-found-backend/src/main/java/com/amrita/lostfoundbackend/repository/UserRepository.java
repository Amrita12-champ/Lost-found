package com.amrita.lostfoundbackend.repository;

import com.amrita.lostfoundbackend.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {
}