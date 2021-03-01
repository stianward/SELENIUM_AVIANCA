package registrarVuelo;
import com.avianca.mavenproject1.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrarVueloAvianca extends Base {

    protected WebDriver driver;
    private String fecha;
    private By validacionLinkPagina = By.id("reservatuvuelo");
    private By validacionPagina = By.xpath("//a[@role=\"presentation\"]");
    private By clickOrigen = By.xpath("//ul/li[@data-terminal=\"BAQ\"]");
    private By lugarOrigen = By.name("pbOrigen_1_1773715561");
    private By clickDestino = By.xpath("//ul/li[@data-terminal=\"CLO\"]");
    private By lugarDestino = By.name("pbDestino_1_1773715561");

    private By clickBtnCalendario = By.xpath("//label[@for=\"pbFechas_1_1773715561\"]");
    private By cambiarMescalendario1 = By.xpath("//div[@class=\"controls next\"]");
    private By mesOrigen = By.xpath("//*[@id=\"ida_regreso_1_1773715561\"]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div[1]/table/tbody/tr/td[1]/div[1]/div[2]");
    private By selDiaOrigen = By.xpath("//td[@class=\"cal1\"]//div[@class=\"number-days\"]/table/tbody");
    private By btnBuscarVuelo = By.xpath("//fieldset//div[@class=\"row\"]/div[@class=\"col-xs-12 text-right col-sm-4 col-md-6 especial-padding-3 noPadl boton-container\"]//button[@title=\"Buscar vuelos\"]");
    private By btnPopupConfirmacion = By.xpath("//div[@class=\"modal-content\"]//div[@class=\"modal-footer\"]/button[@class=\"btn primary continue pull-right\"]");

    public RegistrarVueloAvianca(WebDriver driver) {
        super(driver);
    }

    public void crearViaje() throws InterruptedException {
        //
        click(validacionLinkPagina);

        if (isDisplayed(validacionPagina)) {
            Thread.sleep(10000);
            clear(lugarOrigen);
            Thread.sleep(2000);
            type("Barranquilla", lugarOrigen);
            click(clickOrigen);
            type("Cali", lugarDestino);
            click(clickDestino);
            Thread.sleep(3000);
            click(clickBtnCalendario);
            click(cambiarMescalendario1);
            if (getText(mesOrigen).equals("Abril 2021")) {
                System.out.println("estas en Abril");
                Thread.sleep(3000);
                //SELECCIONA EL DIA IDA
                for (WebElement cell : findElement(selDiaOrigen).findElements(By.tagName("td"))) {
                    if (cell.getText().equals("1")) {
                        cell.click();

                        break;

                    }

                }
                Thread.sleep(2000);
                //SELECCIONA EL DIA REGRESO
                for (WebElement cell : findElement(selDiaOrigen).findElements(By.tagName("td"))) {
                    if (cell.getText().equals("4")) {
                        cell.click();

                        break;

                    }

                }

            } else {
                System.out.println("NO EXISTE EL ELEMENTO");
            }

            findElement(btnBuscarVuelo).click();
            Thread.sleep(3000);
            click(btnPopupConfirmacion);

        }

    }
}
