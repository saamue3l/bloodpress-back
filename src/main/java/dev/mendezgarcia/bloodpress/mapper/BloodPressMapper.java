package dev.mendezgarcia.bloodpress.mapper;

import dev.mendezgarcia.bloodpress.dto.BloodPressDTO;
import dev.mendezgarcia.bloodpress.model.BloodPress;
import org.springframework.stereotype.Component;

@Component
public class BloodPressMapper {

    public BloodPressDTO toDTO(BloodPress entity) {
        if (entity == null) return null;

        return new BloodPressDTO(
            entity.getId(),
            entity.getDate(),
            entity.getSystolic(),
            entity.getDiastolic(),
            entity.getPulse()
        );
    }

    public BloodPress toEntity(BloodPressDTO dto) {
        if (dto == null) return null;

        BloodPress entity = new BloodPress();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setSystolic(dto.getSystolic());
        entity.setDiastolic(dto.getDiastolic());
        entity.setPulse(dto.getPulse());
        return entity;
    }
}
