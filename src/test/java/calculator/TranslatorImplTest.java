package calculator;

import calculator.business.Translator;
import calculator.business.TranslatorImpl;
import calculator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslatorImplTest {
    Translator translator;
    Language from;
    Language to;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = new Language("EN", "English");
        to = new Language("ES", "Spanish");
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testTranslateDummy() throws Exception {
        String response = translator.translate(from, to, "Hello World");
        Assert.assertEquals(response, "Hola Mundo");
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testSuma() throws Exception {
        Addition objectSum = new Addition(3.0f,4.0f);
        Float response = objectSum.getResult();
        Float expected = 7.0f;
        Assert.assertEquals(response, expected);
    }

}