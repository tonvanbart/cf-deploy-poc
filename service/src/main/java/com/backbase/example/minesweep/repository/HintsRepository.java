package com.backbase.example.minesweep.repository;

import com.backbase.example.minesweep.dto.HintsDto;

import java.util.Optional;

/**
 * Created by ton on 15/02/17.
 */
public interface HintsRepository {

    String store(String[] hints);

    Optional<HintsDto> get(String id);
}
