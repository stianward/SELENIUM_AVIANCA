package registrarVuelo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
public class RegistrarVueloTest {

    private WebDriver driver;
    RegistrarVueloAvianca registrar1;

    @Before
    public void setUp() throws Exception {
        registrar1 = new RegistrarVueloAvianca(driver);
        driver = registrar1.chromeDriverConnection();
        registrar1.visit("http://www.avianca.com/co/es/");

    }

    @After
    public void tearDown() {
      // driver.quit();
    }

    @Test
    public void test() throws Exception {
        registrar1.crearViaje();

    }

}
