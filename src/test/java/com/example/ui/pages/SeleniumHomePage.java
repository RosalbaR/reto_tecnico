package com.example.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

// Page Object que representa la página principal de selenium.dev.
// Su responsabilidad es centralizar los localizadores de los elementos de la interfaz para
// reutilizarlos desde las Tasks y Questions de Screenplay.
public class SeleniumHomePage extends PageObject {

    // LINK_DOCUMENTATION define el enlace de navegación a la sección Documentation.
    // Se usa para simular el clic del usuario en la barra principal del sitio.
    public static final Target LINK_DOCUMENTATION = Target.the("enlace Documentation")
            .locatedBy("//a[text()='Documentation']");

    // INPUT_SEARCH representa el campo de búsqueda del sitio.
    // Su objetivo es escribir el texto a buscar y disparar la búsqueda con la tecla Enter.
    public static final Target INPUT_SEARCH = Target.the("campo de búsqueda")
            .locatedBy("//input[@type='search' or @name='search']");

    // SEARCH_RESULTS identifica el contenedor donde aparecen los resultados de búsqueda.
    // Aquí se validará si el texto buscado realmente aparece en la UI.
    public static final Target SEARCH_RESULTS = Target.the("contenedor de resultados")
            .locatedBy("//main");

}
