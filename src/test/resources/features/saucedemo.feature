Feature: Flujo de compra y autenticación en Sauce Demo

  Scenario: Inicio de sesión exitoso y compra completa de un producto
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debería ver la página de productos
    When agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    Then debería ver el producto "Sauce Labs Backpack" en el carrito
    When procede al checkout con nombre "Juan", apellido "Perez" y código postal "15001"
    And finaliza la compra
    Then debería ver el mensaje de confirmación "Thank you for your order!"

  Scenario: Inicio de sesión fallido con usuario bloqueado
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "locked_out_user" y contraseña "secret_sauce"
    Then debería ver un mensaje de error indicando que el usuario está bloqueado

  Scenario: Inicio de sesión fallido con credenciales inválidas
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "usuario_invalido" y contraseña "clave_incorrecta"
    Then debería ver un mensaje de error indicando credenciales inválidas
