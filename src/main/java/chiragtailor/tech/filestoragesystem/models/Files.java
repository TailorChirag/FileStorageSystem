package chiragtailor.tech.filestoragesystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Files extends BaseModel{


    private String fileName;
    private String filePath;
    private Double fileSize;
    private Date uploadedAt;

}
