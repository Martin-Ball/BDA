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

  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=730e14&_nc_ohc=PaDRJrOPZEsAX-u5d3N&_nc_ht=scontent.fros2-1.fna&oh=00_AT_xdq0o-o96wNqDZbPtmb63HL_jGtKOei1La6u3HFcrHQ&oe=61D7F03D" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=730e14&_nc_ohc=PaDRJrOPZEsAX-u5d3N&_nc_ht=scontent.fros2-1.fna&oh=00_AT_xdq0o-o96wNqDZbPtmb63HL_jGtKOei1La6u3HFcrHQ&oe=61D7F03D" width="200" height="400" />

  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=YJOVdBYvnzkAX9XTW8A&_nc_ht=scontent.fros2-1.fna&oh=00_AT_metLDxtULwUoxS5Ej2YG_TnQ3_Fl1xAmTemRcKwni_w&oe=61D79BBD" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=YJOVdBYvnzkAX9XTW8A&_nc_ht=scontent.fros2-1.fna&oh=00_AT_metLDxtULwUoxS5Ej2YG_TnQ3_Fl1xAmTemRcKwni_w&oe=61D79BBD" width="200" height="400" />

  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=NGtWLfv8kwMAX9ygSCk&_nc_oc=AQm4sCmJu_PjYsulmeSxaiYQ7jnxJc8vduBjLpsLS7MEUFROMbGZUncv75bP18rlqGM&_nc_ht=scontent.fros2-1.fna&oh=00_AT-cHiZVOUCxYr3gid3cbNdPAi1PGPpXSkhwxxTKE1h3TQ&oe=61D67DB6" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=NGtWLfv8kwMAX9ygSCk&_nc_oc=AQm4sCmJu_PjYsulmeSxaiYQ7jnxJc8vduBjLpsLS7MEUFROMbGZUncv75bP18rlqGM&_nc_ht=scontent.fros2-1.fna&oh=00_AT-cHiZVOUCxYr3gid3cbNdPAi1PGPpXSkhwxxTKE1h3TQ&oe=61D67DB6" width="200" height="400" />


  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/269967659_10209803699965108_3001825493663848744_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=730e14&_nc_ohc=FtYp_QZOM6wAX_hZOwW&_nc_ht=scontent.fros2-1.fna&oh=00_AT9kPr5UU9YCWqjIyJkQJoQgKtAyP5LZwsEUP5GyQlUHOg&oe=61D69BA7" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/269967659_10209803699965108_3001825493663848744_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=730e14&_nc_ohc=FtYp_QZOM6wAX_hZOwW&_nc_ht=scontent.fros2-1.fna&oh=00_AT9kPr5UU9YCWqjIyJkQJoQgKtAyP5LZwsEUP5GyQlUHOg&oe=61D69BA7" height="300" />
</p>

![BDAIMG1](https://github.com/Martin-Ball/BDA/blob/main/BDA.gif)

