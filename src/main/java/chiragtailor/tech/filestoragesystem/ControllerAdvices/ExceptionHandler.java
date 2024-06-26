package chiragtailor.tech.filestoragesystem.ControllerAdvices;

import chiragtailor.tech.filestoragesystem.Exceptions.PasswordNotFoundException;
import chiragtailor.tech.filestoragesystem.Exceptions.UsernameNotFoundException;
import chiragtailor.tech.filestoragesystem.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UsernameNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleUsernameNotfoundException(UsernameNotFoundException message){
        ExceptionDto dto = new ExceptionDto();
        dto.setMesasgae(message.getMessage());
        return new ResponseEntity<>(
                dto,
                HttpStatus.valueOf(302)
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PasswordNotFoundException.class)
    private ResponseEntity<ExceptionDto> handlePasswordNotFoundException(PasswordNotFoundException message){
        ExceptionDto dto = new ExceptionDto();
        dto.setMesasgae(message.getMessage());
        return new ResponseEntity<>(
                dto,
                HttpStatus.NOT_FOUND
        );
    }
}
