package alura.com.br.Security.ExceptionHandling;

public class BaseException extends Exception {
    private String mensagem;
    public BaseException(String mensagem) {
        super(mensagem);
    }
    public BaseException() {
        super();
    }
}
