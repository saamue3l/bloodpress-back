package dev.mendezgarcia.bloodpress.repository;

import dev.mendezgarcia.bloodpress.model.BloodPress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BloodPressRepository extends JpaRepository<BloodPress, Long> {

    List<BloodPress> findByUserIdOrderByDateDesc(String userId);

    List<BloodPress> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT * FROM blood_pressure_readings bp WHERE " +
           "(:userId IS NULL OR bp.user_id = :userId) AND " +
           "(:startDate IS NULL OR bp.date >= :startDate) AND " +
           "(:endDate IS NULL OR bp.date <= :endDate) " +
           "ORDER BY bp.date DESC",
           nativeQuery = true)
    List<BloodPress> findByFilters(
        @Param("userId") String userId,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );
}
