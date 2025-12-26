package modelo;

public class ArgumentoInvalidoException extends RuntimeException {
	ArgumentoInvalidoException(String mensagem) {
		super(mensagem);
	}
}

class NotFoundException extends RuntimeException {
	NotFoundException(String mensagem) {
		super(mensagem);
	}
}
