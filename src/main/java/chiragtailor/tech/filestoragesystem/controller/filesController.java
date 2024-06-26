package chiragtailor.tech.filestoragesystem.controller;

import chiragtailor.tech.filestoragesystem.models.Files;
import chiragtailor.tech.filestoragesystem.services.FService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class filesController {

    private FService service;

    @Autowired
    public filesController(FService service) {
        this.service = service;
    }

    @GetMapping("/download{id}")
    public ResponseEntity<Files> downloadFile(@PathVariable("id") Long id){
        Files files = service.downloadFile(id);
        return ResponseEntity.ok(files);
    }

    @PostMapping("/upload")
    public Files uploadFile(@RequestBody Files files){
       return service.uploadFile(files);
    }
}
