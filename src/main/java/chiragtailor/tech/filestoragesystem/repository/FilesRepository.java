package chiragtailor.tech.filestoragesystem.repository;

import chiragtailor.tech.filestoragesystem.models.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilesRepository extends JpaRepository<Files, Long> {

    Optional<Files> findById(Long id);

    List<Files> findAll();
}
