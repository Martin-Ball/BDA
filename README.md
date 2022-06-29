## BDA  

Cuando un preventista ingresa a una reunión con el cliente debe conocer cuáles son los productos de interés para poder ofrecer. Actualmente se muestran
Determinados productos sin tener en cuenta el momento en el que se ofrece o a quien. ¿Que pasaría si el preventista sabría en pocos segundos que productos ofrecerle en la reunión?

Para la creación de la app conseguí una base de datos de una distribuidora, la cual guardaba las compras mensuales, precios y productos sobre cada cliente.
Utilice *SQL Server* para trabajar sobre los datos y Android Studio para el armado de la app.

> Venta Mensual

En esta sección se puede seleccionar el cliente y el mes, de esta forma se despliega la información específica, compra promedio mensual y el monto comprado en el mes seleccionado,
además de una gráfica interactiva en la cual se detalla la información

> Productos comprados

Previo a la reunión se puede conocer la información general pero durante ella suele ser necesario revisar los productos comprados por el cliente habitualmente. En esta sección
se puede seleccionar el cliente, la categoría sobre la que se quiere buscar y el producto específico. Se despliega una gráfica que muestra las cantidades compradas por mes,
además, una selección del mes permite la información especifica

> Producto recomendado

Esta sección es la clave del diseño de la app, en ella se busca solucionar la problemática planteada, conocer los productos que debo ofrecer al cliente al momento de entrar.
En conjunto con el mes actual, la app genera mediante *minería de datos* un análisis donde recomienda productos que se deben ofrecer según la característica de compra del cliente
a lo largo del tiempo.

El usuario de la app puede ver en el layout de la app información o descargar un excel donde se especifican los productos a ofrecer.




> Capturas de pantalla

<p float="left">
<img src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40%20(1).jpeg" data-canonical-src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40%20(1).jpeg" width="200" height="400" />

  
  <img src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40%20(2).jpeg" data-canonical-src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40%20(2).jpeg" width="200" height="400" />
  
  <img src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40%20(3).jpeg" data-canonical-src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40%20(3).jpeg" width="200" height="400" />

  
  <img src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40.jpeg" data-canonical-src="https://github.com/Martin-Ball/BDA/blob/main/WhatsApp%20Image%202022-01-02%20at%2021.04.40.jpeg" width="200" height="400" />
  
</p>

![BDAIMG1](https://github.com/Martin-Ball/BDA/blob/main/BDA.gif)

