#language:es
Característica: Agregar un producto al carrito de compra

  Antecedentes:
    Dado el usuario navega a la pagina autenticador

  @AgregarProducto @Regresion
  Esquema del escenario:Se agregan productos en el carrito de compra
    Cuando el usuario ingresa las credenciales para autenticacion "<actor>"
    Dado que se ejecuta el caso de prueba "<test_case>"
    Cuando el usuario selecciona el producto para el carro de compra
      | producto1 | <producto1> |
      | producto2 | <producto2> |
    Cuando el usuario valida  los productos en el carrito de compras
      | producto1 | <producto1> |
      | producto2 | <producto2> |
    Entonces el usuario valida la cantidad de productos en el carrito
      | producto1 | <producto1> |
      | producto2 | <producto2> |

    Ejemplos:
      | test_case                           | producto1           | producto2                | actor         |
      | TC001 - Agregar producto al carrito | Sauce Labs Backpack | Sauce Labs Fleece Jacket | standard_user |