package cz._pf.vopalensky.assignment.backend.exception;

public class RateNotFoundException extends RuntimeException{

    public RateNotFoundException(String shortName){
        super("Rate with short name " + shortName + " not found");
    }
}
