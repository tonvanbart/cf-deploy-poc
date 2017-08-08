package com.backbase.example.minesweep.service;

import com.backbase.example.minesweep.dto.HintsDto;
import com.backbase.example.minesweep.dto.MinefieldDto;
import com.backbase.example.minesweep.repository.MemoryHintsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ton on 15/02/17.
 */
@Component
public class HintsService {

    private final MemoryHintsRepository hintsRepository;

    private static final Logger LOG = LoggerFactory.getLogger(HintsService.class);

    @Autowired
    public HintsService(MemoryHintsRepository hintsRepository) {
        this.hintsRepository = hintsRepository;
        LOG.info("initialized");
    }

    public String storeHints(MinefieldDto minefieldDto) {
        LOG.trace("storeHints()");
        Integer height = minefieldDto.getHeight();
        Integer width = minefieldDto.getWidth();
        String[] bombs = minefieldDto.getMinefield();

        Minefield minefield = Minefield.scan(height, width, bombs);

        return hintsRepository.store(minefield.getHints());
    }

    public String[] getHints(String uuid) {
        Optional<HintsDto> hintsDto = hintsRepository.get(uuid);
        return hintsDto
                .orElseThrow(() -> new UidNotFoundException(uuid))
                .getHints();
    }
}
