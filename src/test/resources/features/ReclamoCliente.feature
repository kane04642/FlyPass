#language:es

Característica: : Creacion de reclamo como cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @ReclamoCliente @OV_TC64 @OV_TC46 @OV_TC49 @regresion
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
      | emailRepre         | <emailRepre>         |
    Cuando el usuario ingresa datos de motivo de reclamo
      | motivo             | <motivo>             |
      | submotivo          | <submotivo>          |
      | descripcionReclamo | <descripcionReclamo> |
    Cuando el usuario ingresa datos notificacion
      | email | <email> |
    Cuando el usuario registra y confirma reclamo

    Ejemplos:
      | actor   | numeroCliente | tipoRelacion | nombreRepre | apellidoRepre | tipoDocumenRepre | numeroDocumenRepre | telefonoFijoRepre | celularRepre | emailRepre          | motivo                 | submotivo                          | descripcionReclamo | email             |
      | cliente | 5195553       | Tercero      | Pepe        | Perez         | DNI              | 52454555           | 25665545          | 3221211204   | ejemplo@ejemplo.com | CONTRATO DE SUMINISTRO | INCUMPLIMIENTO CONTRATO SUMINISTRO | emailRepre         | correo@correo.com |


  @ReclamoCliente @OV_TC96 @regresion
  Esquema del escenario: : Validar no se acepta check política de privacidad

    Cuando el usuario ingresa las credenciales para autenticacion
      | actor | <actor> |
    Dado el usuario selecciona ingreso reclamos
    Entonces el usuario visualiza no se habilita boton siguiente
    Ejemplos:
      | actor |
      | cliente |


  @ReclamoCliente @OV_TC43 @regresion
  Esquema del escenario: : Validar check ingresar datos representante habilita campos
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
      | emailRepre         | <emailRepre>         |

    Ejemplos:
      | actor   | numeroCliente | tipoRelacion | nombreRepre | apellidoRepre | tipoDocumenRepre | numeroDocumenRepre | telefonoFijoRepre | celularRepre | emailRepre          | motivo                 | submotivo                          | descripcionReclamo | email             |
      | cliente | 5195553       | Tercero      | Pepe        | Perez         | DNI              | 52454555           | 25665545          | 3221211204   | ejemplo@ejemplo.com | CONTRATO DE SUMINISTRO | INCUMPLIMIENTO CONTRATO SUMINISTRO | emailRepre         | correo@correo.com |

  @ReclamoCliente @OV_TC103 @regresion
  Esquema del escenario: Cliente valida mensaje de caracteres maximos
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
      | emailRepre         | <emailRepre>         |

    Entonces el usuario valida mensaje maximo caracteres

    Ejemplos:
      | actor   | numeroCliente | tipoRelacion | nombreRepre | apellidoRepre | tipoDocumenRepre | numeroDocumenRepre | telefonoFijoRepre | celularRepre | emailRepre          | motivo                 | submotivo                          | descripcionReclamo | email             |
      | cliente | 5195553       | Tercero      | Pepe        | Perez         | DNI              | 52454555           | 25665545          | 3221211204   | ejemplo@ejemplo.com | CONTRATO DE SUMINISTRO | INCUMPLIMIENTO CONTRATO SUMINISTRO | emailRepreemailRepreemailRepreemailRepreemailRepreemailRepreemailRepreemailRepreemailRepreemailRepre emailRepreemailRepreemailRepreemailRepreemailRepre          | correo@correo.com |

  @ReclamoCliente @OV_TC48 @regresion
  Esquema del escenario: : Cliente no desea respuesta por email
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
      | emailRepre         | <emailRepre>         |
    Cuando el usuario ingresa datos de motivo de reclamo
      | motivo             | <motivo>             |
      | submotivo          | <submotivo>          |
      | descripcionReclamo | <descripcionReclamo> |
    Cuando el usuario no desea respuesta por email
    Cuando el usuario registra y confirma reclamo

    Ejemplos:
      | actor   | numeroCliente | tipoRelacion | nombreRepre | apellidoRepre | tipoDocumenRepre | numeroDocumenRepre | telefonoFijoRepre | celularRepre | emailRepre          | motivo                 | submotivo                          | descripcionReclamo | email             |
      | cliente | 5195553       | Tercero      | Pepe        | Perez         | DNI              | 52454555           | 25665545          | 3221211204   | ejemplo@ejemplo.com | CONTRATO DE SUMINISTRO | INCUMPLIMIENTO CONTRATO SUMINISTRO | emailRepre         | correo@correo.com |


  @ReclamoCliente @OV_TC62 @regresion
  Esquema del escenario: Validar check ingresar otra dirección de notificaciòn
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
      | emailRepre         | <emailRepre>         |
    Cuando el usuario ingresa datos de motivo de reclamo
      | motivo             | <motivo>             |
      | submotivo          | <submotivo>          |
      | descripcionReclamo | <descripcionReclamo> |
    Cuando el usuario no desea respuesta por email
    Cuando el usuario ingresa otra dicreccion de notificacion
      | departamento | <departamento>       |
      | provincia    | <provincia>          |
      | distrito     | <distrito>           |
      | referencia   | <referencia> |

    Ejemplos:
      | actor   | numeroCliente | tipoRelacion | nombreRepre | apellidoRepre | tipoDocumenRepre | numeroDocumenRepre | telefonoFijoRepre | celularRepre | emailRepre          | motivo                 | submotivo                          | descripcionReclamo | departamento | provincia | distrito | referencia     |
      | cliente | 5195553       | Tercero      | Pepe        | Perez         | DNI              | 52454555           | 25665545          | 3221211204   | ejemplo@ejemplo.com | CONTRATO DE SUMINISTRO | INCUMPLIMIENTO CONTRATO SUMINISTRO | emailRepre         | CALLAO       | CALLAO     | CALLAO    | referenciatest |
