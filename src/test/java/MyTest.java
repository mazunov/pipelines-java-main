import ObjectPage.BmiCalculatorPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
    }
    @Test
    public void testBmiCalculation() {
        BmiCalculatorPage copyBmiCalculatorPage = new BmiCalculatorPage(driver);

        // enviar la estatura
        copyBmiCalculatorPage.setHeight("171");
        // enviar el peso
        copyBmiCalculatorPage.setWeight("70");
        // dar click sobre boton de calcular
        copyBmiCalculatorPage.calculateBmi();
        // Verificar resultado de bmi y bmi category
        assertEquals("23.9", copyBmiCalculatorPage.getBmi());
        assertEquals("Normal",copyBmiCalculatorPage.getBmiCategory());
    }

    @Test
    public void testBmiCalculationBmiOverweight() {
        BmiCalculatorPage copyBmiCalculatorPage = new BmiCalculatorPage(driver);

        // enviar la estatura
        copyBmiCalculatorPage.setHeight("171");
        // enviar el peso
        copyBmiCalculatorPage.setWeight("80");
        // dar click sobre boton de calcular
        copyBmiCalculatorPage.calculateBmi();
        // Verificar resultado de bmi y bmi category
        assertEquals("27.4", copyBmiCalculatorPage.getBmi());
        assertEquals("Overweight",copyBmiCalculatorPage.getBmiCategory());
    }

    @Test
    public void testBmiCalculationBmiUnderweight(){
        BmiCalculatorPage copyBmiCalculatorPage = new BmiCalculatorPage(driver);

        // enviar la estatura
        copyBmiCalculatorPage.setHeight("171");
        // enviar el peso
        copyBmiCalculatorPage.setWeight("50");
        // dar click sobre boton de calcular
        copyBmiCalculatorPage.calculateBmi();
        // Verificar resultado de bmi y bmi category
        assertEquals("27.4", copyBmiCalculatorPage.getBmi());
        assertEquals("Underweight",copyBmiCalculatorPage.getBmiCategory());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}