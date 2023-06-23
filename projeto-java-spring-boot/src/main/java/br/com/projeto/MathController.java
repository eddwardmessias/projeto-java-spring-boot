package br.com.projeto;

import br.com.projeto.exceptions.UnsuportMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/mut/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mut(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double med(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value!");
        }

        return (convertToDouble(numberOne) / convertToDouble(numberTwo)) /2;
    }

    @RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
    public Double raiz(
            @PathVariable(value = "numberOne") String numberOne
    )throws Exception {

        if (!isNumeric(numberOne)) {
            throw new UnsuportMathOperationException("Please set a numeric value!");
        }
        Double result =convertToDouble(numberOne);
        return Math.sqrt(result);
    }


    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }


    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
