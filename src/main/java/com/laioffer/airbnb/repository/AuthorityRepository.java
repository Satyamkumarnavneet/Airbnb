package com.laioffer.airbnb.repository;

import com.laioffer.airbnb.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
