package chiragtailor.tech.filestoragesystem.services;

import chiragtailor.tech.filestoragesystem.models.Files;
import chiragtailor.tech.filestoragesystem.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Files> downloadFile() {
        return filesRepository.findAll();
    }
}
