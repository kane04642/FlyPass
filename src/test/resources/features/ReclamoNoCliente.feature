#language:es

Característica: : Creacion de reclamo como NO cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @ReclamoNoCliente
  Esquema del escenario: : Usuario no registrado registra reclamo
    Cuando el usuario ingresa al menu de reclamos no clientes
    Cuando el usuario ingresa los datos del reclamante no cliente
      | nombre          | <nombre>          |
      | apellidos       | <apellidos>       |
      | tipoDocumento   | <tipoDocumento>   |
      | numeroDocumento | <numeroDocumento> |
      | telefono        | <telefono>        |
      | celular         | <celular>         |
      | correo          | <correo>          |


    Ejemplos:
      | nombre | apellidos | tipoDocumento | numeroDocumento | telefono | celular     | correo            |  |
      | pepe   | perez     | DNI           | 80221408        | 93320101 | 93302014545 | correo@correo.com |  |