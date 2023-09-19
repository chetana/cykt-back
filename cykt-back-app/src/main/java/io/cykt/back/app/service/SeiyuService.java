package io.cykt.back.app.service;

import com.google.common.collect.Lists;
import io.cykt.back.app.dto.SeiyuDto;
import io.cykt.back.app.entity.SeiyuEntity;
import io.cykt.back.app.repository.SeiyuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeiyuService {
    private final SeiyuRepository seiyuRepository;
    public SeiyuDto findByName(String name) {
        return new SeiyuDto(seiyuRepository.findByName(name).orElseThrow().getName());
    }

    public SeiyuDto save(SeiyuDto seiyuDto) {
        return  new SeiyuDto(seiyuRepository.save(new SeiyuEntity(null, seiyuDto.name())).getName());
    }

    public List<SeiyuDto> findAllSeiyuEntitys() {
        Iterable<SeiyuEntity> SeiyuEntitys = this.seiyuRepository.findAll();
        return Lists.newArrayList(SeiyuEntitys).stream().map(seiyuEntity -> new SeiyuDto(seiyuEntity.getName())).toList();
    }
}
