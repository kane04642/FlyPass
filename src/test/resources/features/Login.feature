#language:es

Característica: : Login en https://www.saucedemo.com/

  @Login @regresion
  Esquema del escenario: : Login Exitoso
    Dado el usuario navega a la pagina autenticador
    Cuando el usuario ingresa las credenciales para autenticacion "<actor>"

    Ejemplos:
      | actor   |  |
      | standard_user |  |
