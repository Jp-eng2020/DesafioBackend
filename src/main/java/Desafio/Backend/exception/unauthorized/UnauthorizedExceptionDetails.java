package Desafio.Backend.exception.unauthorized;

import Desafio.Backend.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class UnauthorizedExceptionDetails extends ExceptionDetails {
}