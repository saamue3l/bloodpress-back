package dev.mendezgarcia.bloodpress.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "blood_pressure_readings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodPress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer systolic;

    @Column(nullable = false)
    private Integer diastolic;

    @Column(nullable = false)
    private Integer pulse;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
