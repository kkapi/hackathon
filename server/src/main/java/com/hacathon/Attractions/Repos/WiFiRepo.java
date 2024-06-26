package com.hacathon.Attractions.Repos;

import com.hacathon.Attractions.Domain.WiFi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Данный интерфейс используется для доступа к БД Wi_Fi
 */
public interface WiFiRepo extends JpaRepository<WiFi, Long> {
    List<WiFi> findAll();


    @Query(value = "SELECT t " +
            "FROM WiFi t " +
            "WHERE sqrt(((t.lat - :latitude)*62555)*((t.lat - :latitude)*62555) + ((t.lon - :longitude)*111153)*((t.lon - :longitude)*111153)) < :radius " +
            "order by sqrt(((t.lat - :latitude)*62555)*((t.lat - :latitude)*62555) + ((t.lon - :longitude)*111153)*((t.lon - :longitude)*111153))")
    List<WiFi> findNeedPoint(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") double radius);
}
