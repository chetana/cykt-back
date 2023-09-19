package io.cykt.back.app.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import io.cykt.back.app.entity.SeiyuEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeiyuRepository extends DatastoreRepository<SeiyuEntity, Long> {
    Optional<SeiyuEntity> findByName(String name);
}