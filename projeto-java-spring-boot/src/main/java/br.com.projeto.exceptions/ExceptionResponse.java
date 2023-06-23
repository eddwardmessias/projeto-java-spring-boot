package br.com.projeto.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID =1L;

    private Date timesamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timesamp, String message, String details) {
        this.timesamp = timesamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimesamp() {
        return timesamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
