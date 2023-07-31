package alura.com.br.Security.ExceptionHandling;

import org.aspectj.lang.NoAspectBoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;


@RestControllerAdvice
public class HandleException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MedicoNotFoundException.class)
    public ResponseException error404(MedicoNotFoundException medicoNotFoundException) {
        return ResponseException.builder()
                .mensagem(medicoNotFoundException.getMensagem())
                .status(medicoNotFoundException.getStatus())
                .campos(medicoNotFoundException.getCampos())
                .build();
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(Exception.class)
    public ResponseException error404(Exception e){
        return ResponseException.builder()
                .mensagem(e.getMessage())
                .build();
    }
}