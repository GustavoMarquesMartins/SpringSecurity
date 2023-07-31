package alura.com.br.Security.ExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DuplicidadeException extends BaseException {
    private final HttpStatus status = HttpStatus.CONFLICT;
    private String mensagem;
    private List<String> campos;
}
