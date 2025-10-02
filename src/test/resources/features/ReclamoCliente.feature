#language:es

Característica: : Creacion de reclamo como cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador


  @ReclamoCliente @regresion
  Esquema del escenario: : Cliente registrado realiza reclamo
    Cuando el usuario ingresa las credenciales para autenticacion
      | actor | <actor> |

    Dado el usuario selecciona ingreso reclamos
    Cuando el usuario ingresa los datos del reclamante
      | numeroCliente | <numeroCliente> |

    Cuando el usuario ingresa datos del representante
      | tipoRelacion       | <tipoRelacion>       |
      | nombreRepre        | <nombreRepre>        |
      | apellidoRepre      | <apellidoRepre>      |
      | tipoDocumenRepre   | <tipoDocumenRepre>   |
      | numeroDocumenRepre | <numeroDocumenRepre> |
      | telefonoFijoRepre  | <telefonoFijoRepre>  |
      | celularRepre       | <celularRepre>       |
      | emailRepre         | <emailRepre>       |

    Cuando el usuario ingresa datos de motivo de reclamo
      | motivo             | <motivo>        |
      | submotivo          | <submotivo>     |
      | descripcionReclamo | <descripcionReclamo> |

    Cuando el usuario ingresa datos notificacion
      | email | <email> |


    Ejemplos:
      | actor   | numeroCliente | tipoRelacion | nombreRepre | apellidoRepre | tipoDocumenRepre | numeroDocumenRepre | telefonoFijoRepre | celularRepre | emailRepre          | motivo                 | submotivo                          | descripcionReclamo | email             |
      | cliente | 5195553       | Tercero      | Pepe        | Perez         | DNI              | 52454555           | 25665545          | 3221211204   | ejemplo@ejemplo.com | CONTRATO DE SUMINISTRO | INCUMPLIMIENTO CONTRATO SUMINISTRO | emailRepre         | correo@correo.com |