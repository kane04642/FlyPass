#language:es

  Característica: Se desea crear un servicio

  @Crearservicio
  Esquema del escenario: Crear servicio como persona fisica
    Dado El usuario realiza el login de SO Cloud "<actor>"
   Y el paramedico selecciona menu recepcion llamada
    Cuando El paramedico ingresa los datos de informacion del cliente "<tipoSolicitante>" "<tipoDocumento>" "<numeroDocumento>" "<telefono>" "<celular>" "<email>" "<nombre>" "<edad>" "<tipoEdad>" "<sexo>" "<pais>"
    Y El paramedico ingresa datos motido de consulta "<motivo>" "<cuadroClinico>"
    Y El paramedico ingresa clasificacion de la atencion "<clasificacion>"
    Y El paramedico ingresa informacion geografica "<ciudad>" "<barrio>" "<direccion>"
    Y El paramedico da click en generar servicio
    Entonces El paramedico visualiza mensaje exitoso

    Ejemplos:
      | actor      | tipoSolicitante     | tipoDocumento | numeroDocumento | telefono   | celular    | email                         | nombre        | edad | tipoEdad | sexo     | motivo | cuadroClinico | clasificacion | ciudad   | barrio  | direccion   | pais     |
      | paramedico | 1- Personas Físicas | Cedula - NIT  | 1030590371      | 3008212437 | 3008212437 | daniel.contreras@grupoemi.com | carlos torres | 42   | Años     | Femenino | 30     | test          | 05            | MEDELLIN | ALAMEDA | cra 2 # 2 2 | Colombia |