package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.Gson;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import entities.TemplateRestResponse;
import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.alfabank.alfatest.cucumber.api.AlfaEnvironment;
import ru.alfabank.alfatest.cucumber.api.AlfaScenario;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by onotole on 27.01.17.
 */
@Slf4j
public class TemplateSteps {

    @Delegate
    AlfaScenario alfaScenario = AlfaScenario.getInstance();

    @И("^из переменной \"([^\"]*)\" получаем общую сумму бонусов и помещаем его в переменную \"([^\"]*)\"$")
    public void getTotalBonusFromResponse(String varNameSource, String varNameDst) throws Throwable {
        String restResponse = (String) alfaScenario.getVar(varNameSource);
        Gson gson = new Gson();
        TemplateRestResponse templateRestResponse = gson.fromJson(restResponse, TemplateRestResponse.class);
        alfaScenario.setVar(varNameDst, templateRestResponse.getBalance());
        alfaScenario.write("Получили общее количество бонусов с REST: " + templateRestResponse.getBalance());
    }
    @Тогда("^поле \"([^\"]*)\" содержит (?:значения из списка|значение)$")
    public void chooseOperationByName(String fieldName, List<String> values) {
        SelenideElement fieldInfo = alfaScenario.getCurrentPage().getElement(fieldName);
        for (String value : values) {
            fieldInfo.waitUntil(Condition.matchesText(value), 3000);
        }
    }

}
