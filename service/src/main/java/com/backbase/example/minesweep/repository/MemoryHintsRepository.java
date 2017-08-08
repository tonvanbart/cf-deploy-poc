package com.backbase.example.minesweep.repository;

import com.backbase.example.minesweep.dto.HintsDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * In-memory repository of minefield hints.
 * Created by ton on 15/02/17.
 */
@Repository
public class MemoryHintsRepository implements HintsRepository {

    private Map<String, HintsDto> storedHints = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(MemoryHintsRepository.class);

    @Override
    public String store(String[] hints) {
        LOG.info("store()");
        String uuid = UUID.randomUUID().toString();
        HintsDto hintsDto = new HintsDto(uuid, hints);
        storedHints.put(hintsDto.getId(), hintsDto);
        LOG.info("store() -> {}", uuid);
        return uuid;
    }

    @Override
    public Optional<HintsDto> get(String id) {
        LOG.info("get({})", id);
        return Optional.ofNullable(storedHints.get(id));
    }
}
