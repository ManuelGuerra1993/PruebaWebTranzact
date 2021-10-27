Feature: Registro de nuevos usuarios
  Como usuario necesito poder registrarme con mi correo personal para poder loguearme.

  #Etiqueta o tag que usara el runner
  @FlujoPrincipal
    ##Scenario outline para la utilización de tabla de datos
  Scenario Outline: Registro y validación de datos
    Given valido que la aplicacion "<web>" este operativa
    When hago clic en el botón Sign in
    And completo el correo electronico "<correo>" y clic en Create an account
    Then se muestra la pantalla Create "CREATE AN ACCOUNT"
    And completo la información personal "<Title>" "<FirstName>" "<LastName>" "<Password>" "<Day>" "<Month>" "<year>"
    And completo mi dirección "<Company>" "<Address1>" "<Address2>" "<City>" "<State>" "<Postal>" "<Country>" "<Adicional>" "<HomePhone>" "<MobilePhone>" "<Alias>"
    And hago clic en el botón Register
    Then se muestra la pantalla My Account "MY ACCOUNT"
    And valido la url "<web>index.php?controller=my-account"
    And valido el usuario "<FirstName> <LastName>"
    And valido que el botón Log out este disponible

    #Tabla de datos
    Examples:
      | web                            | correo          | Title | FirstName | LastName | Password | Day | Month | year | Company  | Address1    | Address2    | City | State  | Postal | Country       | Adicional           | HomePhone | MobilePhone | Alias |
      | http://automationpractice.com/ | 88898@gmail.com | Mr    | Manuel    | Guerra   | 123456   | 19  | July  | 1993 | Tranzact | av. calle 1 | av. calle 2 | Lima | Kansas | 55555  | United States | Pruebas Manu Guerra | 2889725   | 977146556   | Manu  |
