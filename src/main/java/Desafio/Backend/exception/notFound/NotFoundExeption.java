package Desafio.Backend.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundExeption extends RuntimeException{
    public NotFoundExeption(String message) {
        super(message);
    }
}
