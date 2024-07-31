package cz._pf.vopalensky.assignment.backend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
public class RateErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String error;

}
