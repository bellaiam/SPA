package com.tbb.krazyolives.data;

import com.tbb.krazyolives.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
