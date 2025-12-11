package com.saucedemo.f2x.stepdefinitions.agregarProductos;

import com.saucedemo.f2x.tasks.ValidarCarrito.ValidarProductoEnCarrito;
import com.saucedemo.f2x.tasks.agregarProducto.AgregarProducto;
import io.cucumber.java.es.Cuando;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductoSteps {
    @Cuando("el usuario selecciona el producto para el carro de compra")
    public void elUsuarioSeleccionaElProductoParaElCarroDeCompra(Map<String, String> producto) {
        String producto1 = producto.get("producto1");
        String producto2 = producto.get("producto2");
        theActorInTheSpotlight().wasAbleTo(
                AgregarProducto.alCarrito(producto1),
                AgregarProducto.alCarrito(producto2)
        );
    }

    @Cuando("el usuario valida  los productos en el carrito de compras")
    public void elUsuarioValidaLosProductosEnElCarritoDeCompras(Map<String, String> producto) {
        producto.values().forEach(nombreProducto ->
                theActorInTheSpotlight().attemptsTo(
                        ValidarProductoEnCarrito.conNombre(nombreProducto)
                )
        );
    }
}
