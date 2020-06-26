package calculator.business;

import calculator.Addition;
import calculator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TranslatorImpl implements Translator {

    @Override
    public String translate(Language from, Language to, String text) {
        return "Hola Mundo";
    }

}
