package dev.mendezgarcia.bloodpress.service;

import dev.mendezgarcia.bloodpress.dto.BloodPressDTO;
import dev.mendezgarcia.bloodpress.exception.ResourceNotFoundException;
import dev.mendezgarcia.bloodpress.mapper.BloodPressMapper;
import dev.mendezgarcia.bloodpress.model.BloodPress;
import dev.mendezgarcia.bloodpress.repository.BloodPressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BloodPressService {

    @Autowired
    private BloodPressRepository repository;

    @Autowired
    private BloodPressMapper mapper;

    public List<BloodPressDTO> getAll(String userId, LocalDateTime startDate, LocalDateTime endDate) {
        List<BloodPress> entities = repository.findByFilters(userId, startDate, endDate);
        return entities.stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    public BloodPressDTO getById(Long id) {
        BloodPress entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Blood pressure reading not found with id: " + id));
        return mapper.toDTO(entity);
    }

    public BloodPressDTO create(BloodPressDTO dto) {
        if (dto.getSystolic() <= dto.getDiastolic()) {
            throw new IllegalArgumentException("Systolic must be greater than diastolic");
        }

        BloodPress entity = mapper.toEntity(dto);
        BloodPress saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public BloodPressDTO update(Long id, BloodPressDTO dto) {
        BloodPress existing = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Blood pressure reading not found with id: " + id));

        if (dto.getSystolic() != null) existing.setSystolic(dto.getSystolic());
        if (dto.getDiastolic() != null) existing.setDiastolic(dto.getDiastolic());
        if (dto.getPulse() != null) existing.setPulse(dto.getPulse());
        if (dto.getDate() != null) existing.setDate(dto.getDate());

        BloodPress updated = repository.save(existing);
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Blood pressure reading not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
