package pl.kul.operations.validation;

public enum OperationValidatoError {
    NULL_VALUE ("Nie podano zadnego polecenia. (validation)"),
    INVALID_OPERATION ("Nie ma takiego polecenia (validation)."),
    INVALID_NUMBER_OF_ARGUMENTS ("Nie poprawna ilosc argumenruw. (validation)"),
    INVALID_VALUE ("Nie prowiedlowa podana wartosc."),
    INVALID_VALUE_ID("Indefikator powinien byc liczba."),
    INVALID_ID( "O takim id nie istnieje elementu."),
    INVALID_ARGUMENT ("Argumenty sa nie prawiedlole. (validation)");

    private final String message;

    OperationValidatoError(String message){ this.message = message; }

    public String getMessage() {
        return message;
    }
}
