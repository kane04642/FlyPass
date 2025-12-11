package com.saucedemo.f2x.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login  extends PageObject {

    public static final Target TXT_USERNAME = Target.the("Digitar username")
            .located(By.cssSelector("input[placeholder='Username']"));
    public static final Target TXT_PASSWORD = Target.the("Digitar Password")
            .located(By.cssSelector("input[placeholder='Password']"));
    public static final Target BTN_LOGIN = Target.the("Botòn login")
            .located(By.id("login-button"));
    public static final Target LBL_PAGE = Target.the("Titulo ingreso")
            .located(By.cssSelector(".app_logo"));
    public static String convertirNombreADataTest(String nombreProducto) {
        return "add-to-cart-" + nombreProducto
                .toLowerCase()
                .replace("(", "")
                .replace(")", "")
                .replace(".", "")
                .replace(" ", "-");
    }

    public static Target BOTON_AGREGAR_PRODUCTO(String nombreProducto) {
        String dataTest = convertirNombreADataTest(nombreProducto);
        return Target.the("Botón agregar al carrito para el producto " + nombreProducto)
                .located(By.cssSelector("[data-test='" + dataTest + "']"));
    }
    public static Target PRODUCTO_EN_CARRITO(String nombreProducto) {
        return Target.the("Producto '" + nombreProducto + "' en el carrito")
                .located(By.xpath("//div[@data-test='inventory-item-name' and normalize-space(text())='" + nombreProducto + "']"));
    }

    public static final Target LNK_CARRITO = Target.the("Link carrito de compras")
            .located(By.id("shopping_cart_container"));

    public static final Target BADGE_CARRITO = Target.the("Cantidad de productos en el carrito")
            .located(By.cssSelector("[data-test='shopping-cart-badge']"));


}
