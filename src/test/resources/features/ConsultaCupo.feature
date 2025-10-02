#language:es

Característica: Consultar cupo de credito

  @CupoCredito
  Esquema del escenario: : Consultar cupo de credito
    Dado el usuario navega a la pagina autenticador
    Cuando el usuario seleciona consultar mi linea de credito

    Ejemplos:
      | NombreApellido | email            | telefono | celular   | clave        | confirmarClave | numCliente | numRecibo |
      | lucas lucas    | lucas@correo.com | 2287897  | 999778844 | Contrasena1* | Contrasena1*   | 123456     | 123456    |
