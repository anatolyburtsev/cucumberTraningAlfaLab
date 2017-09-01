package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.api.AlfaPage;
import ru.alfabank.alfatest.cucumber.api.AlfaPage.Name;

@Name("Страница входа")
public class LoginPage extends AlfaPage {

    @FindBy(css = "div.authorization__login-input input:first-child")
    @Name("Логин")
    private SelenideElement login;

    @FindBy(css = "div.input-password input:first-child")
    @Name("Пароль")
    private SelenideElement password;

    @FindBy(xpath = "//span[text()='Войти']/parent::button")
    @Name("Войти")
    private SelenideElement enterButton;
}