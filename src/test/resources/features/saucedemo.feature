Feature: Flujo de compra y autenticación en Sauce Demo
  @Sesion_exitoso @regresion
  Scenario: Inicio de sesión exitoso
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debería ver la página de productos "Swag Labs"
  @Sesion_usuario_bloqueado @regresion
  Scenario: Inicio de sesión fallido con usuario bloqueado
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "locked_out_user" y contraseña "secret_sauce"
    Then Valido mensaje "Sorry, this user has been locked out"
  @Sesion_credenciales_invalidas @regresion
  Scenario: Inicio de sesión fallido con credenciales inválidas
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "usuario_invalido" y contraseña "clave_incorrecta"
    Then Valido mensaje "Username and password do not match"
  @Agregar_producto @regresion
  Scenario: Agregar producto al carrito desde el catálogo
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "standard_user" y contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    Then el ícono del carrito debería mostrar "1" producto

  @Ver_producto @regresion
  Scenario: Verificar producto en carrito de compra
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "standard_user" y contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    Then debería ver el producto "Sauce Labs Backpack" en el carrito

  @Compra_completa @regresion
  Scenario: Compra completa de un producto
    Given el usuario navega a la página de Sauce Demo
    When inicia sesión con el usuario "standard_user" y contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    And procede al checkout con nombre "Juan", apellido "Perez" y código postal "15001"
    And finaliza la compra
    Then debería ver el mensaje de confirmación "Thank you for your order!"

