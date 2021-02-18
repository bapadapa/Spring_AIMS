package com.seughyun.java.project03.aims.repository;


import com.seughyun.java.project03.aims.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlockRepository extends JpaRepository<Block, Long> {

}
