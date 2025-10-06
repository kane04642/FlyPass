#language:es

Característica: Validar el pago de un recibo por parte de un cliente

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @ReclamoCliente @OV_TC64 @regresion
  Esquema del escenario: Cliente consulta factura para pago
    Cuando el usuario ingresa las credenciales para autenticacion
      | actor | <actor> |
    Cuando el usuario selecciona menu pago de recibos

    Ejemplos:
      | actor |
      | clienteFactura |