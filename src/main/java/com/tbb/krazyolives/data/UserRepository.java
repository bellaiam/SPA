package com.tbb.krazyolives.data;

import com.tbb.krazyolives.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
 User findByEmail(String email);


}
