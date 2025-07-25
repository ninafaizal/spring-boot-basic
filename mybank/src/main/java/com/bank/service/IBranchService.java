package com.bank.service;

import com.bank.entity.BranchEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IBranchService {
	
	List<BranchEntity> getAllBranch();
	
	BranchEntity getBranchById(Long id);
	
	BranchEntity createBranch(BranchEntity branch);
	
	//BranchEntity updateBranch(Long id, BranchEntity updatedBranch);
	
	void deleteBranch(Long id);
	
	List<BranchEntity> searchBranchByName(String name);
	
	List<BranchEntity> searchBranchByCreationDateBetween(LocalDateTime from, LocalDateTime to);

}
