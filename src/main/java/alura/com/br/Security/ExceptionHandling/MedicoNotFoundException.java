package alura.com.br.Security.ExceptionHandling;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
public class MedicoNotFoundException extends BaseException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final String mensagem;
    private final List<String> campos;
}
