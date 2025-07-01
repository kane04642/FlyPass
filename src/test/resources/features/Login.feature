#language:es

Característica: : Login SO Cloud Directorio activo

  Esquema del escenario: : Login Exitoso
    Dado el usuario navega a la pagina autenticador
    Cuando el usuario ingresa las credenciales para autenticacion
      | usuario  | <usuario>  |
      | password | <password> |
    Entonces el usuario espera la pagina de home
    Ejemplos:
      | usuario                       | password      |
      | daniel.contreras@grupoemi.com | Colombia2025* |
