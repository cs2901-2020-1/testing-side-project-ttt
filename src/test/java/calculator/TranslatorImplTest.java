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

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testResta() throws Exception {
        Substraction objectSub = new Substraction(10.0f, 7.0f);
        Float response = objectSub.getResult();
        Float expected = 3.0f;
        Assert.assertEquals(response, expected);
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testMultiplicacion() throws Exception {
        Multiplication objectSub = new Multiplication(5.0f, 6.0f);
        Float response = objectSub.getResult();
        Float expected = 30.0f;
        Assert.assertEquals(response, expected);
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testDivision() throws Exception {
        Divide objectSub = new Divide(42.0f, 14.0f);
        Float response = objectSub.getResult();
        Float expected = 3.0f;
        Assert.assertEquals(response, expected);
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testExpresion() throws Exception {
        CalculatorFacade objectExpresion = new CalculatorFacade();
        double response = objectExpresion.getResult("40-31+4*3-15/5");
        double expected = 18.0f;
        Assert.assertEquals(response, expected);
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testExecute() throws Exception {
        testSuma();
        testResta();
        testMultiplicacion();
        testDivision();
        testExpresion();
    }

}