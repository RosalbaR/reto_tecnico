@AUTOMATION_API
Feature: Pruebas API en reqres.in
  Como QA quiero validar endpoints básicos en reqres.in

  @CASO_API_1
  Scenario Outline: Caso de Prueba 4 - Listar usuarios
    Given que se consulta la lista de usuarios de la página <page>
    Then la respuesta tendrá estado <status> y contendrá "<key>"

    Examples:
      | page | status | key  |
      | 2    | 200    | page |

  @CASO_API_2
  Scenario Outline: Caso de Prueba 5 - Crear usuario
    Given que se crea un usuario con nombre "<name>" y trabajo "<job>"
    Then la respuesta tendrá estado <status> y contendrá el nombre "<expected_name>"

    Examples:
      | name     | job    | status | expected_name |
      | morpheus | leader | 201    | morpheus      |

  @CASO_API_3
  Scenario Outline: Caso de Prueba 6 - Actualizar usuario
    Given que se actualiza el usuario <id> con nombre "<name>" y trabajo "<job>"
    Then la respuesta tendrá estado <status> y contendrá el trabajo "<expected_job>"

    Examples:
      | id | name     | job           | status | expected_job  |
      | 2  | morpheus | zion resident | 200    | zion resident |
