package statservice.server.src.main.resources.java.ru.practicum;


import statservice.dto.src.main.java.ru.practicum.dto.HitDto;
import statservice.dto.src.main.java.ru.practicum.dto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;

public interface HitService {

    void addHit(HitDto hitDto);

    List<StatsDto> findStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique);
}