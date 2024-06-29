package chiragtailor.tech.filestoragesystem.services;

import chiragtailor.tech.filestoragesystem.models.Files;
import chiragtailor.tech.filestoragesystem.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FIleService implements FService{

    private final FilesRepository filesRepository;

    @Autowired
    public FIleService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    @Override
    public Files uploadFile(Files files) {
        return filesRepository.save(files);
    }

    @Override
    public Files downloadFile(Long id) {
        return filesRepository.findById(id).orElse(null);
    }
}
