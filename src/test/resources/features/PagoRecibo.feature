#language:es

Característica: Pago de recibo por cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @PagoRecibo @regresion
  Esquema del escenario: Cliente registrado desea pagar factura
    Cuando el usuario ingresa las credenciales para autenticacion
      | actor | <actor> |
    Cuando el usuario selecciona menu pago recibos
    Cuando el usuario selecciona el numero de recibo para pago
      | NoRecibo | <NoRecibo> |

    Ejemplos:
      | actor   | NoRecibo |
      | cliente | 1038800  |
