package pl.kul.operations.validation;

public enum OperationValidatoError {
    NULL_VALUE ("Nie podano zadnego polecenia."),
    INVALID_OPERATION ("Nie ma takiego polecenia."),
    INVALID_NUMBER_OF_ARGUMENTS ("Nie poprawna ilosc argumentow."),
    INVALID_VALUE ("Nie prowiedlowa podana wartosc."),
    INVALID_VALUE_ID("Indentyfikator powinien byc liczba."),
    INVALID_ID( "Produkt o takim id nie istnieje."),
    INVALID_ARGUMENT ("Argumenty sa nie prawidlowe.");

    private final String message;

    OperationValidatoError(String message){ this.message = message; }

    public String getMessage() {
        return message;
    }
}
