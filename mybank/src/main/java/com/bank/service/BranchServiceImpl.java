package com.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.BranchEntity;
import com.bank.repo.IBranchRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements IBranchService{
	
	private final IBranchRepo branchRepo;
	
	@Override
    public List<BranchEntity> getAllBranch() {
        return null;
    }

    @Override
    public BranchEntity getBranchById(Long id) {
        return null;
    }

    @Override
    public BranchEntity createBranch(BranchEntity branch) {
        return branchRepo.save(branch);
    }

//    @Override
//    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
//        return null;
//    }
    
    @Override
    public void deleteBranch(Long id) {
        if (!branchRepo.existsById(id)) {
        	// throw new DemoAppException("Cannot delete. Branch not found with ID: " + id);
        }
        branchRepo.deleteById(id);
    }
    
    @Override
    public List<BranchEntity> searchBranchByName(String name) {
    	return branchRepo.findByBranchNameContainingIgnoreCase(name);
    }
    
    @Override
    public  List<BranchEntity> searchBranchByCreationDateBetween(LocalDateTime from, LocalDateTime to) {
    	return branchRepo.findByCreationDateBetween(from, to);
    }
    
   

}
