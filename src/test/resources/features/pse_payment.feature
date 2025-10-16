# language: es
Característica: Procesamiento de pagos PSE en Wompi
  Como usuario del comercio
  Quiero procesar pagos mediante PSE
  Para permitir a mis clientes pagar con transferencia bancaria

  Escenario: Flujo exitoso de pago PSE
    Dado que tengo un merchant válido en el ambiente UAT
    Cuando creo una transacción PSE con datos válidos
    Entonces la transacción debe ser creada exitosamente
    Y el estado inicial debe ser "PENDING"
    Y debo recibir una URL para redirección al banco

  Escenario: Crear transacción PSE con monto inválido
    Dado que tengo un merchant válido en el ambiente UAT
    Cuando intento crear una transacción PSE con monto cero
    Entonces debe retornar un error de validación
    Y el mensaje de error debe indicar "El monto debe ser mayor a cero"

  Escenario: Crear transacción PSE sin email del usuario
    Dado que tengo un merchant válido en el ambiente UAT
    Cuando intento crear una transacción PSE sin email
    Entonces debe retornar un error de validación
    Y el mensaje de error debe indicar "El email es requerido"