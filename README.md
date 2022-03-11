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
<img src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270409202_10209803678524572_256468901394625968_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=UoOaMVWV_5YAX_eGvkn&_nc_ht=scontent.fros9-1.fna&oh=00_AT_14J6BXdZy0J8JrPRT4XZpNCCx6zSJeAH0Wex-rG8U2g&oe=62306BA4" data-canonical-src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270409202_10209803678524572_256468901394625968_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=UoOaMVWV_5YAX_eGvkn&_nc_ht=scontent.fros9-1.fna&oh=00_AT_14J6BXdZy0J8JrPRT4XZpNCCx6zSJeAH0Wex-rG8U2g&oe=62306BA4" width="200" height="400" />

  
  <img src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=730e14&_nc_ohc=b5edHsiKT4YAX9wDz3N&tn=h69wmpM9SRohpJgs&_nc_ht=scontent.fros9-2.fna&oh=00_AT-TteSDL1wZKBluStfoPZM2W0BygncKtVX8dENH-kF1sg&oe=6230ED7D" data-canonical-src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=730e14&_nc_ohc=b5edHsiKT4YAX9wDz3N&tn=h69wmpM9SRohpJgs&_nc_ht=scontent.fros9-2.fna&oh=00_AT-TteSDL1wZKBluStfoPZM2W0BygncKtVX8dENH-kF1sg&oe=6230ED7D" width="200" height="400" />
  
  <img src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=EUjR1v69EUcAX93bqia&_nc_ht=scontent.fros9-2.fna&oh=00_AT_FSSkcNNkoTAuOdS1RCL4Rzeh7fjdn9i7CyS8CMLo_oA&oe=623098FD" data-canonical-src="https://scontent.fros9-2.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=EUjR1v69EUcAX93bqia&_nc_ht=scontent.fros9-2.fna&oh=00_AT_FSSkcNNkoTAuOdS1RCL4Rzeh7fjdn9i7CyS8CMLo_oA&oe=623098FD" width="200" height="400" />

  
  <img src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=xKlCFlSwkzcAX8JeZAN&_nc_oc=AQmwat26DtyoEAOG3XWAGa9tTu8aqj1MzEW4Gt3fi_oUv6rC3x00JgEwT7Aa_pgrIas&_nc_ht=scontent.fros9-1.fna&oh=00_AT8M0x0redf2h7Jw-i_3jmPfrt9WI4h3JPbD1LRDojeIPA&oe=622F7AF6" data-canonical-src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=xKlCFlSwkzcAX8JeZAN&_nc_oc=AQmwat26DtyoEAOG3XWAGa9tTu8aqj1MzEW4Gt3fi_oUv6rC3x00JgEwT7Aa_pgrIas&_nc_ht=scontent.fros9-1.fna&oh=00_AT8M0x0redf2h7Jw-i_3jmPfrt9WI4h3JPbD1LRDojeIPA&oe=622F7AF6" width="200" height="400" />

  
  <img src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/269967659_10209803699965108_3001825493663848744_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=730e14&_nc_ohc=IIhzvapcmDgAX90Y_xO&_nc_ht=scontent.fros9-1.fna&oh=00_AT9u0-IZ8gPUSZutKOpTvmjk4Xgp-trcbbb-hDfL6T16tA&oe=622F98E7" data-canonical-src="https://scontent.fros9-1.fna.fbcdn.net/v/t39.30808-6/269967659_10209803699965108_3001825493663848744_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=730e14&_nc_ohc=IIhzvapcmDgAX90Y_xO&_nc_ht=scontent.fros9-1.fna&oh=00_AT9u0-IZ8gPUSZutKOpTvmjk4Xgp-trcbbb-hDfL6T16tA&oe=622F98E7" width="200" height="400" />
</p>

![BDAIMG1](https://github.com/Martin-Ball/BDA/blob/main/BDA.gif)

