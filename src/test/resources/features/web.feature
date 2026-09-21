@AUTOMATION_WEB
Feature: Pruebas Web en la pagina selenium.dev
  Como QA quiero validar flows básicos de la web de selenium.dev

  @CASO_WEB_1
  Scenario: Caso de Prueba 1 - Ver página de inicio
    Given que un usuario abre la página de inicio
    Then debería ver el título "Selenium automates browsers. That's it!"

  @CASO_WEB_2
  Scenario: Caso de Prueba 2 - Navegar en el apartado "Documentation"
    Given que un usuario abre la página de inicio
    When selecciona el apartado "Documentation"
    Then la url de la pagina debería contener "/documentation"

  @CASO_WEB_3
  Scenario: Caso de Prueba 3 - Flujo de búsqueda
    Given que un usuario abre la página de inicio
    When realiza una búsqueda por "WebDriver"
    Then los resultados deberían contener "WebDriver"
