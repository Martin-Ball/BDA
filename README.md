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
<img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270409202_10209803678524572_256468901394625968_n.jpg?_nc_cat=108&ccb=1-6&_nc_sid=730e14&_nc_ohc=lzyU4l0HmRkAX8wk6uP&_nc_ht=scontent.fros2-1.fna&oh=00_AT8dc6BLY9mGF0IhhkwVi-YtZm2QOY3b_KbxK2BVF5ydcw&oe=627D8B64" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270409202_10209803678524572_256468901394625968_n.jpg?_nc_cat=108&ccb=1-6&_nc_sid=730e14&_nc_ohc=lzyU4l0HmRkAX8wk6uP&_nc_ht=scontent.fros2-1.fna&oh=00_AT8dc6BLY9mGF0IhhkwVi-YtZm2QOY3b_KbxK2BVF5ydcw&oe=627D8B64" width="200" height="400" />

  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-6&_nc_sid=730e14&_nc_ohc=N3uLc2zmNbEAX86J_FI&_nc_ht=scontent.fros2-1.fna&oh=00_AT8Dk_MZo5qNbFvzX9_e-Cqe9tamEciFV-ZJsilZ_GGtpg&oe=627E0D3D" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270239162_10209803678644575_1186621157542228606_n.jpg?_nc_cat=100&ccb=1-6&_nc_sid=730e14&_nc_ohc=N3uLc2zmNbEAX86J_FI&_nc_ht=scontent.fros2-1.fna&oh=00_AT8Dk_MZo5qNbFvzX9_e-Cqe9tamEciFV-ZJsilZ_GGtpg&oe=627E0D3D" width="200" height="400" />
  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-6&_nc_sid=730e14&_nc_ohc=X9HlVkNAEhMAX-2H4fX&_nc_ht=scontent.fros2-1.fna&oh=00_AT_qZF1AKEiRAAi9bYJMDtAE-Ij2Px0NATWra8vPQwHfUg&oe=627DB8BD" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270188336_10209803678484571_3593874652975958633_n.jpg?_nc_cat=104&ccb=1-6&_nc_sid=730e14&_nc_ohc=X9HlVkNAEhMAX-2H4fX&_nc_ht=scontent.fros2-1.fna&oh=00_AT_qZF1AKEiRAAi9bYJMDtAE-Ij2Px0NATWra8vPQwHfUg&oe=627DB8BD" width="200" height="400" />

  
  <img src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-6&_nc_sid=730e14&_nc_ohc=wyrgpw-lN_0AX9utbxs&_nc_oc=AQkbY_71XwhJw7j-9Ct6C7wLoPLW93kEd2Ub4wsmDdzcIOuMxcKnnWW_MxGeM87sUVo&_nc_ht=scontent.fros2-1.fna&oh=00_AT9EjVBv0fafuBYJOpK5r7vlVdP_OeTuhPsxFxXcsfEO1A&oe=627E94F6" data-canonical-src="https://scontent.fros2-1.fna.fbcdn.net/v/t39.30808-6/270234164_10209803679244590_2222211874414139029_n.jpg?_nc_cat=108&ccb=1-6&_nc_sid=730e14&_nc_ohc=wyrgpw-lN_0AX9utbxs&_nc_oc=AQkbY_71XwhJw7j-9Ct6C7wLoPLW93kEd2Ub4wsmDdzcIOuMxcKnnWW_MxGeM87sUVo&_nc_ht=scontent.fros2-1.fna&oh=00_AT9EjVBv0fafuBYJOpK5r7vlVdP_OeTuhPsxFxXcsfEO1A&oe=627E94F6" width="200" height="400" />
  
</p>

![BDAIMG1](https://github.com/Martin-Ball/BDA/blob/main/BDA.gif)

