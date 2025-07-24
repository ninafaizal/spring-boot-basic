package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entity.ProductEntity;

@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, Long> {}