package chiragtailor.tech.filestoragesystem.controller;

import chiragtailor.tech.filestoragesystem.models.Files;
import chiragtailor.tech.filestoragesystem.services.FService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storagesystem")
public class filesController {

    private FService service;

    @Autowired
    public filesController(FService service) {
        this.service = service;
    }

    @GetMapping("/download")
    public ResponseEntity<List<Files>> downloadFile(){
        ResponseEntity<List<Files>> response =
                new ResponseEntity<>(service.downloadFile(), HttpStatus.OK);
        return response;
    }


    @PostMapping()
    public Files uploadFile(@RequestBody Files files){
       return service.uploadFile(files);
    }
}
