package com.rafaelandrade.emailcontroller.repository;

import com.rafaelandrade.emailcontroller.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}


