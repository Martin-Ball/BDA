## BDA  

Cuando un preventista ingresa a una reunion con el cliente debe conocer cuales son los productos de interes para poder ofrecer. Actualmente se muestran
determinados productos sin tener en cuenta el momento en el que se ofrece o a quien. ¿Que pasaria si el preventista sabria en pocos segundos que productos ofrecerle en la reunion?

Para la creacion de la app consegui una base de datos de una distribuidora, la cual guardaba las compras mensuales, precios y productos sobre cada cliente.
Utilice *SQL Server* para trabajar sobre los datos y Android Studio para el armado de la app.

> Venta Mensual

En esta seccion se puede seleccionar el cliente y el mes, de esta forma se despliega la informacion especifica, compra promedio mensual y el monto comprado en el mes seleccionado,
ademas de una grafica interactiva en la cual se detalla la informacion

> Productos comprados

Previo a la reunion se puede conocer la informacion general pero durante ella suele ser necesario revisar los productos comprados por el cliente habitualmente. En esta seccion
se puede seleccionar el cliente, la categoria sobre la que se quiere buscar y el producto especifico. Se despliega una grafica que muestra las cantidades compradas por mes,
ademas, una seleccion del mes permite la informacion especifica

> Producto recomendado

Esta seccion es la clave del diseño de la app, en ella se busca solucionar la problematica planteada, conocer los productos que debo ofrecer al cliente al momento de entrar.
En conjunto con el mes actual, la app genera mediante *mineria de datos* un analisis donde recomienda productos que se deben ofrecer segun la caracteristica de compra del cliente
a lo largo del tiempo.

El usuario de la app puede ver en el layout de la app informacion o descargar un excel donde se especifican los productos a ofrecer.




> Capturas de pantalla

<p float="left">
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270409202_10209803678524572_256468901394625968_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=i71YeioHsDIAX9zBqTW&_nc_ht=scontent.fros2-1.fna&oh=00_AT9h6c8sdVeNfLijLBu5OK13rQsO63Gq2inHkeCVdkVp9w&oe=61D76E64" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270409202_10209803678524572_256468901394625968_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=i71YeioHsDIAX9zBqTW&_nc_ht=scontent.fros2-1.fna&oh=00_AT9h6c8sdVeNfLijLBu5OK13rQsO63Gq2inHkeCVdkVp9w&oe=61D76E64" width="200" height="400" />
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=730e14&_nc_ohc=PaDRJrOPZEsAX-u5d3N&_nc_ht=scontent.fros2-1.fna&oh=00_AT_xdq0o-o96wNqDZbPtmb63HL_jGtKOei1La6u3HFcrHQ&oe=61D7F03D" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=730e14&_nc_ohc=PaDRJrOPZEsAX-u5d3N&_nc_ht=scontent.fros2-1.fna&oh=00_AT_xdq0o-o96wNqDZbPtmb63HL_jGtKOei1La6u3HFcrHQ&oe=61D7F03D" width="200" height="400" />
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=YJOVdBYvnzkAX9XTW8A&_nc_ht=scontent.fros2-1.fna&oh=00_AT_metLDxtULwUoxS5Ej2YG_TnQ3_Fl1xAmTemRcKwni_w&oe=61D79BBD" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=YJOVdBYvnzkAX9XTW8A&_nc_ht=scontent.fros2-1.fna&oh=00_AT_metLDxtULwUoxS5Ej2YG_TnQ3_Fl1xAmTemRcKwni_w&oe=61D79BBD" width="200" height="400" />
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=NGtWLfv8kwMAX9ygSCk&_nc_oc=AQm4sCmJu_PjYsulmeSxaiYQ7jnxJc8vduBjLpsLS7MEUFROMbGZUncv75bP18rlqGM&_nc_ht=scontent.fros2-1.fna&oh=00_AT-cHiZVOUCxYr3gid3cbNdPAi1PGPpXSkhwxxTKE1h3TQ&oe=61D67DB6" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=730e14&_nc_ohc=NGtWLfv8kwMAX9ygSCk&_nc_oc=AQm4sCmJu_PjYsulmeSxaiYQ7jnxJc8vduBjLpsLS7MEUFROMbGZUncv75bP18rlqGM&_nc_ht=scontent.fros2-1.fna&oh=00_AT-cHiZVOUCxYr3gid3cbNdPAi1PGPpXSkhwxxTKE1h3TQ&oe=61D67DB6" width="200" height="400" />
</p>

![BDAIMG1](https://github.com/Martin-Ball/PowerMeter/blob/main/WhatsApp%20Video%202022-01-02%20at%2019.53.gif)


