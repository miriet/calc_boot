package com.test.calc;

import com.test.calc.common.PrintType;
import com.test.calc.control.DecoratorFactory;
import com.test.calc.decorator.DecoratorIF;
import org.springframework.stereotype.Service;

@Service
public class Calculation {

    private DecoratorIF decorator;
    public String  calc(PrintType printType){
        String result = "";
        for (int idx = 2; idx < 10; idx++) {
            result += calc(idx, printType);
        }
        return result;
    }
    public String calc(int param, PrintType printType) {
        String result = "";
        result = getTitle(param, printType);
        result += getContent(param, printType);
        return result;
    }

    private String getTitle(int param, PrintType printType){
        String result = "";
        decorator = DecoratorFactory.getDecorator(printType);
        result = decorator.getTitle(param);
        return result;
    }

    private String  getContent(int param, PrintType printType) {
        String result = "";
        decorator = DecoratorFactory.getDecorator(printType);
        for (int order = 1; order < 10; order++) {
            String calcData = param + " X " + order + " = " + param * order;
            result += decorator.getContent(calcData);
        }
        return result;
    }

}
