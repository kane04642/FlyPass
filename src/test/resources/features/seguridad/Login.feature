#language:es

Característica: : Login Seguridad

  Como usuario de ti requiero ingresar las credenciales para ingresar al seguridad de SO

  Esquema del escenario: : Login Exitoso
    Dado el usuario navega a la pagina autenticador
    Cuando el usuario ingresa las credenciales para autenticacion
      | usuario  | <usuario>  |
      | password | <password> |
    Entonces el usuario espera la pagina de home
    Ejemplos:
      | usuario                 | password      |
      | socloud.qa@grupoemi.com | Colombia2024* |
