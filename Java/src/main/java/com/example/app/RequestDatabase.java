package com.example.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDatabase extends JpaRepository<Request, Long> {
}
