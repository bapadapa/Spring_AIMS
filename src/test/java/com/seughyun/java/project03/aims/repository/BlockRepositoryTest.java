package com.seughyun.java.project03.aims.repository;

import com.seughyun.java.project03.aims.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud(){
        Block block = new Block();
        block.setName("Justin");
        block.setReason("배고파서");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);

        List<Block> blockList = blockRepository.findAll();

        assertEquals(blockList.size() , 1);
        assertEquals(blockList.get(0).getName() , "Justin");
    }
}