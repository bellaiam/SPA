package com.tbb.krazyolives.data;

import com.tbb.krazyolives.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Integer> {
    List<AuthGroup> findByaEmail(String email);

}