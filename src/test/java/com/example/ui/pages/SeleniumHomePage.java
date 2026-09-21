package com.example.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumHomePage extends PageObject {

    public static final Target LINK_DOCUMENTATION = Target.the("enlace Documentation")
            .located(By.cssSelector("a[href='/documentation']"));

    public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda")
            .located(By.id("docsearch-1"));

    public static final Target INPUT_SEARCH = Target.the("campo de búsqueda")
            .located(By.cssSelector("input[type='search'], input[placeholder*='Search']"));

    public static final Target SEARCH_RESULTS = Target.the("contenedor de resultados")
            .locatedBy("//main");

}
