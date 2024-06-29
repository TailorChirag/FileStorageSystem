package chiragtailor.tech.filestoragesystem.services;

import chiragtailor.tech.filestoragesystem.models.Files;

import java.util.List;

public interface FService {

    Files uploadFile(Files files);

    List<Files> downloadFile();

}
