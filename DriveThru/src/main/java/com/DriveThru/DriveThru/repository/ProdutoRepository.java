package com.DriveThru.DriveThru.repository;

import com.DriveThru.DriveThru.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}