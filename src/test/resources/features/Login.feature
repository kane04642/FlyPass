#language:es

Característica: : Login SO Cloud Directorio activo

  @LoginSO
  Esquema del escenario: : Login Exitoso
    Dado el usuario navega a la pagina autenticador
    Cuando el usuario ingresa las credenciales para autenticacion "<actor>"
    Entonces el usuario espera la pagina de home
    Ejemplos:
      | actor      |  |
      | paramedico |  |
