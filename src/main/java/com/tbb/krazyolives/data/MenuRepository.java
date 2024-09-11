package com.tbb.krazyolives.data;

import com.tbb.krazyolives.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

//    @Query(nativeQuery = true)
//    List<Menu> findMenuItems(long id);
//
//
}
