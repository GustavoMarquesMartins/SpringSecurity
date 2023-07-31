package alura.com.br.Security.ExceptionHandling;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public record ResponseException(String mensagem, HttpStatus status, List<String> campos) {
}
