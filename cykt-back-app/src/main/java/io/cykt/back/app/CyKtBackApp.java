package io.cykt.back.app;

import com.google.common.collect.Lists;
import io.cykt.back.app.entity.SeiyuEntity;
import io.cykt.back.app.repository.SeiyuRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
@AllArgsConstructor
public class CyKtBackApp {
    private final SeiyuRepository seiyuRepository;

    public static void main(String[] args) {
        SpringApplication.run(CyKtBackApp.class, args);
    }

    @ShellMethod("Saves a SeiyuEntity to Cloud Datastore: save-SeiyuEntity <name>")
    public String saveSeiyuEntity(String name) {
        SeiyuEntity savedSeiyuEntity = this.seiyuRepository.save(new SeiyuEntity(null, name));
        return savedSeiyuEntity.toString();
    }

    @ShellMethod("Loads all SeiyuEntitys")
    public String findAllSeiyuEntitys() {
        Iterable<SeiyuEntity> SeiyuEntitys = this.seiyuRepository.findAll();
        return Lists.newArrayList(SeiyuEntitys).toString();
    }

    @ShellMethod("Removes all SeiyuEntitys")
    public void removeAllSeiyuEntitys() {
        this.seiyuRepository.deleteAll();
    }
}
