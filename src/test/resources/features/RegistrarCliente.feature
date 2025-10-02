#language:es

Característica: :Registro de un nuevo cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @Registrar @OV_TC530 @regresion
  Esquema del escenario: : Registro sin numero de recibo actualizado
    Cuando el usuario ingresa datos del registro
      | NombreApellido | <NombreApellido> |
      | email          | <email>          |
      | telefono       | <telefono>       |
      | celular        | <celular>        |
      | clave          | <clave>          |
      | confirmarClave | <confirmarClave> |
      | numCliente     | <numCliente>     |
      | numRecibo      | <numRecibo>      |

    Entonces el usuario valida boton de error en recibo no valido
    Ejemplos:
      | NombreApellido | email            | telefono | celular   | clave        | confirmarClave | numCliente | numRecibo |
      | lucas lucas    | lucas@correo.com | 2287897  | 999778844 | Contrasena1* | Contrasena1*   | 123456     | 123456    |

  @Registrar @OV_TC94 @regresion
  Esquema del escenario: : Registro sin diligenciar los campos obligatorios
    Cuando el usuario ingresa datos del registro
      | NombreApellido | <NombreApellido> |
      | email          | <email>          |

    Entonces el usuario valida mensaje de campos obligatorios
    Ejemplos:
      | NombreApellido | email            |  |  |  |  |  |  |
      | lucas lucas    | lucas@correo.com |  |  |  |  |  |  |

  @Registrar @OV_TC91 @regresion
  Esquema del escenario: : Registro exitoso de usuario persona natural
    Cuando el usuario ingresa datos del registro
      | NombreApellido | <NombreApellido> |
      | email          | <email>          |
      | telefono       | <telefono>       |
      | celular        | <celular>        |
      | clave          | <clave>          |
      | confirmarClave | <confirmarClave> |
      | numCliente     | <numCliente>     |
      | numRecibo      | <numRecibo>      |

    Entonces el usuario valida mensaje de registro exitoso
    Ejemplos:
      | NombreApellido | email            | telefono | celular   | clave        | confirmarClave | numCliente | numRecibo |
      | lucas lucas    | lucas@correo.com | 2287897  | 999778844 | Contrasena1* | Contrasena1*   | 123456     | 123456    |

  @Registrar @OV_TC93 @regresion
  Esquema del escenario: Validar se cancela el registro del nuevo usuario
    Cuando el usuario ingresa datos del registro
      | NombreApellido | <NombreApellido> |
      | email          | <email>          |

    Cuando el usuario da click en cancelar registro
    Entonces el usuario valida mensaje cancelar
    Ejemplos:
      | NombreApellido | email            |  |  |  |  |  |  |
      | lucas lucas    | lucas@correo.com |  |  |  |  |  |  |

  @Registrar @OV_TC92 @regresion
  Esquema del escenario: : Registro de una nueva empresa
    Dado el usuario da click en pestaña de empresa
    Cuando el usuario ingresa datos del registro de empresa
      | ruc            | <ruc>            |
      | razonSocial    | <razonSocial>    |
      | email          | <email>          |
      | telefono       | <telefono>       |
      | celular        | <celular>        |
      | clave          | <clave>          |
      | confirmarClave | <confirmarClave> |
      | numCliente     | <numCliente>     |
      | numRecibo      | <numRecibo>      |

    Entonces el usuario valida mensaje exitoso de creacion
    Ejemplos:
      | ruc    | email            | telefono | celular   | clave        | confirmarClave | numCliente | numRecibo | razonSocial |
      | 223355 | lucas@correo.com | 2287897  | 999778844 | Contrasena1* | Contrasena1*   | 123456     | 123456    | razonSocial |