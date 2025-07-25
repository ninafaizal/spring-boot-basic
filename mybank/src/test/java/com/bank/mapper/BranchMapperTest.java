package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.entity.BranchEntity;
import com.bank.model.BranchDTO;

import java.time.LocalDateTime;

@SpringBootTest
public class BranchMapperTest {
	
	@Autowired
    private BranchMapper branchMapper;
    
	@Test
    void testEntityToDtoAndBack() {
		BranchEntity entity = new BranchEntity();
		entity.setBranchID(10L);
		entity.setBranchName("Main Branch");
		entity.setBranchPostCode("40400");
		entity.setCreationDate(LocalDateTime.now());
		
		// convert to DTO
        BranchDTO dto = branchMapper.toDto(entity);
        assertNotNull(dto);
        assertEquals(entity.getBranchID(), dto.getBranchID());
        assertEquals(entity.getBranchName(), dto.getBranchName());
        assertEquals(entity.getBranchPostCode(), dto.getBranchPostCode());

        // convert back to entity
        BranchEntity convertedEntity = branchMapper.toEntity(dto);
        assertNotNull(convertedEntity);
        assertEquals(dto.getBranchID(), convertedEntity.getBranchID());
        assertEquals(dto.getBranchName(), convertedEntity.getBranchName());
        assertEquals(dto.getBranchPostCode(), convertedEntity.getBranchPostCode());
    }

}
