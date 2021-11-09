package ntou.cs.m4rcus.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ntou.cs.m4rcus.entity.Melody;

@Repository
public interface SongRepository extends MongoRepository<Melody,String>{
	List<Melody> findByTitleContainingIgnoreCase(String songTitle);
	List<Melody> findByTitleContainingIgnoreCase(String songTitle,Sort sort);
}
