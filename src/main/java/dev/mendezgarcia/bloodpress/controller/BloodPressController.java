package dev.mendezgarcia.bloodpress.controller;

import dev.mendezgarcia.bloodpress.dto.BloodPressDTO;
import dev.mendezgarcia.bloodpress.service.BloodPressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bloodPressureReadings")
public class BloodPressController {

    @Autowired
    private BloodPressService service;

    @GetMapping
    public ResponseEntity<List<BloodPressDTO>> getAll(
        @RequestParam(required = false) String userId,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        List<BloodPressDTO> readings = service.getAll(userId, startDate, endDate);
        return ResponseEntity.ok(readings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodPressDTO> getById(@PathVariable Long id) {
        BloodPressDTO reading = service.getById(id);
        return ResponseEntity.ok(reading);
    }

    @PostMapping
    public ResponseEntity<BloodPressDTO> create(@Valid @RequestBody BloodPressDTO dto) {
        BloodPressDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodPressDTO> update(
        @PathVariable Long id,
        @Valid @RequestBody BloodPressDTO dto
    ) {
        BloodPressDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
