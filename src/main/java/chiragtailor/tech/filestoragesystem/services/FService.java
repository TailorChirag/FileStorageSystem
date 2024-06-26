package chiragtailor.tech.filestoragesystem.services;

import chiragtailor.tech.filestoragesystem.models.Files;

public interface FService {

    Files uploadFile(Files files);

    Files downloadFile(Long id);

}
