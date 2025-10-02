#language:es

Característica: : Creacion de reclamo como NO cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @ReclamoNoCliente @regresion
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

    Cuando el usuario ingresa datos de direccion de ocurrencia
      | tipoCalle         | <tipoCalle>              |
      | nombreCalle       | <nombreCalle>            |
      | Nro               | <Nro>                    |
      | tipoEdificio      | <tipoEdificio>           |
      | edificio          | <edificio>               |
      | tipoVivienda      | <tipoVivienda>           |
      | nombreVivienda    | <nombreVivienda>         |
      | piso              | <piso>                   |
      | tipoInterior      | <tipoInterior>           |
      | interior          | <interior>               |
      | tipoComite        | <tipoComite>             |
      | nombreComite      | <nombreComite>           |
      | Mz                | <Mz>                     |
      | Lt                | <Lt>                     |
      | tipoConVivienda   | <tipoConVivienda>        |
      | nombreConVivienda | <nombreConVivienda> |
      | departamento      | <departamento>           |
      | provincia         | <provincia>              |
      | distrito          | <distrito>               |

    Cuando el usuario selecciona identificacion del bien contratado
      | bienContratado  | <bienContratado> |
      | bienDescripcion | <bienDescripcion> |

    Cuando el usuario selecciona reclamo OSINERGMIN
      | motivo             | <motivo>    |
      | submotivo          | <submotivo> |
      | descripcionReclamo | <descripcionReclamo>       |

    Cuando el usuario da click en guardar

    Ejemplos:
      | nombre | apellidos | tipoDocumento | numeroDocumento | telefono | celular     | correo            | tipoCalle | nombreCalle | Nro | tipoEdificio | tipoVivienda | nombreVivienda | piso | tipoInterior | interior | tipoComite | nombreComite | Mz | Lt | tipoConVivienda | nombreConVivienda | departamento | provincia | distrito | edificio | motivo         | submotivo               | descripcionReclamo | bienContratado |bienDescripcion |
      | pepe   | perez     | DNI           | 870305        | 93320101 | 93302014545 | correo@correo.com | AVENIDA   | CAnovas     | 26  | Edificio     | Feria        | Canovas        | 4    | Casa         | B        | Etapa      | Canovas      | B  | 1  | Pueblo Joven    | CAnovas           | CALLAO       | CALLAO    | LA PERLA | 26       | OBRAS EXTERNAS | DESMONTE EN VÍA PÚBLICA | Test               | PRODUCTO       |bienDescripcion |