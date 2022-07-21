package com.test.calc;

import com.test.calc.common.PrintType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CalcBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalcBootApplication.class, args);
    }

    @GetMapping("/calc")
    public String calc(@RequestParam(value = "printType", defaultValue = "HTML") PrintType printType,
                       @RequestParam(value = "index", defaultValue = "0") int index){
        String result = "";
        Calculation calc = new Calculation();
        if (index == 0) {
            result = calc.calc(printType);
        }else {
            result = calc.calc(index, printType);
        }
        return result;
    }
}
