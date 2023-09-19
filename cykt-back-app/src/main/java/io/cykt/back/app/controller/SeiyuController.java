package io.cykt.back.app.controller;

import io.cykt.back.app.dto.SeiyuDto;
import io.cykt.back.app.service.SeiyuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seiyu")
@RequiredArgsConstructor
public class SeiyuController {
    private final SeiyuService seiyuService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<SeiyuDto> getByname() {
        return seiyuService.findAllSeiyuEntitys();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{name}")
    public SeiyuDto getByName(@PathVariable String name) {
        return seiyuService.findByName(name);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public SeiyuDto create(@RequestBody SeiyuDto seiyuDto) {
        return seiyuService.save(seiyuDto);
    }
}
