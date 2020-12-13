# Enlaza Proyect - Open Canarias
Este pryecto has sido desarrollado para la empresa de Open Canarias, tal y como ya se resume en el propio nombre, la idea resumida de la aplicacion es la de que una 
persona cualquiera pueda realizar la reserva de una habitacion en un hotel.


## Modelo de Datos
El modelo de datos sigue la suguiente descripcion o estructura:
* **Users Table:** Esta tabla sera donde encontraremos los datos a predisponer para realizar el registro.
  * **Name:** Nombre del usuario
  * **Email** Email del usuario
  * **Password** Contraseña del usuario
  
* **Rooms Table:** Esta tabla sera donde encontraremos los datos que veran los usuarios de las habitaciones.
  * **Number:** Numero de la habitacion
  * **Name:** Nombre de la suite
  * **Subname:** Subnombre de la habitacion
  * **Description:** Descripcion de la habitacion
  * **Numperson:** Numero de las personas que pueden ocupar la habitacion
  * **Size:** Tamaño de la habitacion
  * **Price:** Precio de la reserva
  * **Starating:** Numero de Valoraciones
  * **Url_img:** Imagen de la habitacion
  
* **Bookings Table:** Esta tabla sera donde encontraremos los datos que tendars que dar para desarrollar la reserva.
  * **Check_in:** Fecha de entrada
  * **Check_out** Fecha de salida
  * **Diet** Tipo de plan de reserva
  
## Entidad Relacion
<img src="img/entidadrelacion.png" alt="Entidad Relacion" width="750px" height="400px" />

## Modelo Relacional
<img src="img/modelorelacional.png" alt="Entidad Relacion" width="750px" height="400px" />

## Casos de Uso
<img src="img/casosdeuso.png" alt="Entidad Relacion" width="750px" height="400px" />

## Prototipo Proyecto Enlaza

This will be the prototype or at least the initial idea of ​​how the application should be, once developed.

 In this documentation I will try to explain both the functionality of each of the windows, for this I will start by explaining the menu.
 
 ## Table of Contents
1. [Menu](#menu)
2. [Windows](#windows)
3. [Usability](#usability)

### MENU

The menu in this prototype is activated by clicking on the next marked area, once ejected the entire window is minimized, or at least its scale, to be able to see the menu in all its splendor, in this we can find a button that takes us home.

<img src="img/Screenshot_1.png" alt="Imagen1" width="200px" height="400px" />
<img src="img/Screenshot_2.png" alt="Imagen2" width="200px" height="400px" />


### WINDOWS

Among the windows that our interface is divided into, we can find the following:
* **Start Window:** In this window we can find a simple starting window of any application, when clicking on the button, you would give way to the form window.

<img src="img/Screenshot_3.png" alt="Imagen3" width="200px" height="400px" />

* **Login or registration form:** In this window you will have to register, or in case you already have an account, simply enter your identifying information and enter.

<img src="img/Screenshot_4.png" alt="Imagen4" width="400px" height="400px" />

* **Filter Window:** In this window you must put the filter data of the search, such as the departure and arrival date and the place.

<img src="img/Screenshot_5.png" alt="Imagen5" width="200px" height="400px" />

* **Discover window:** In this window you must select between the different destinations to select.

<img src="img/Screenshot_7.png" alt="Imagen7" width="200px" height="400px" />

* **Room Window:** In this window will be where you can see all the information about the room itself, data, such as a brief description, its location or a Review of other users. And if you click on the button at the end, you will go to the payment gateway.

![Imagen3](img/Screenshot_9.png)
![Imagen3](img/Screenshot_10.png)



### Usability

When we design multiplatform applications, the interface that we propose will be essential for the user to feel comfortable working with it. Bad design can cause customers to leave our application.

Within the context of computer applications and software development, usability is defined as the discipline that studies how to design websites and applications so that users can interact with them in the easiest, most comfortable and most intuitive way possible.

Among the elements that I have taken into account when trying to create a design as legible as possible and that does not provide any kind of difficulty or deficiency when interpreting its content, they have been:

* **Colors:** Among the colors that I have used in this design we find:
  * **#193566:** Choose to use this color as it is one that was already present on your website.
  * **#FF6E00:** This is another one that is present on your website.
  * **#FFFFFF:** This is another one that is present on your website.
  * **#E9E9E9:** White Drift.
  * **#000000:** It is the black of all life.
  * **#97A7C3:** I selected it for being a color that would be derived from # 193566 (Navy Blue).
  * **#ECF0F3:** I select it because it is a color that would be derived from # 193566 (Navy Blue).
  
* **Use of Colors:** The use that I gave to each of the colors were the following:
  * **#193566:** I have used this color mainly for the use of small details, such as some buttons, or in case you want to highlight small elements or icons.
  * **#FF6E00:** I have used it for the subject of titles, subtitles and some other elements in which I used it to create contrast. 
  * **#FFFFFF & # E9E9E9:** I use them mainly to create a gradient in the background of many of the windows of my interface or prototype.
  * **#000000:** I use it to create a little contrast between the text in that window, when the background is starring an image.
  * **#97A7C3 & # ECF0F3:** I use them for the menu background or for some details to contrast with the Navy Blue (# 193566).
  * **#ECF0F3:** I select it because it is a color that would be derived from # 193566 (Navy Blue).
  
* **Typography:** The fonts I have used are:
  * **Product Sans:** I use it for the titles of most items.
  * **Source Sans Pro:** I use it for the subtitles of most elements.
  * **Quicksand:** I use this typeface mainly for the description inside the rooms or for elements such as reviews. Also, he used different weights within it from "Light", "Regular" and "Medium".
  
  * **Interactive elements:** In the prototype you will find the buttons as interactive elements, in each of the majority of windows, in some, they will be a button to complete the room search, in others they will be arrows to move between elements of a slideshow, or in another to display the menu.

* **Data presentation:** In this case, when talking about the presentation of data, I think I should emphasize precisely the last window, which is where I specify information about the rooms, there what I do is precisely divide the content into different sections, from the location of said room, a brief description, the reviews of other users or a section to complete the download.


### Pila Tecnologica

La pila tecnologica la divido en las siguientes tecnologias:

* **Backend:** PHP 7 / Laravel Framework
* **Microservicio:** Lumen Framework
* **BBDD:** MySQL
* **Frontend:** Android Kotlin

### Repositorios

Los repositorios  encontramos este mismo y el de https://github.com/JavierMedina11/Prototipo-ProyectoEnlaza


### Planificacion

La planificacion de la app, la he tenido que ir haciendo sobre la marcha, es decir, ya que obtuve la informacion de la empresa con tanto restraso he tenido que esforzarme en intentar hacerlo todo en un periodo de 3 o 3 semanas y media.

### Conclusiones, opiniones y reflexiones

Mi conclusion final respecto al proyecto, es que no ha sido sencillo, ya que al trabajar con un pila tecnologica en la que no tenia experiencia, sobre todo, 
ya no tanto el backend (Laravel & Lumen), sino Android Studio a base de Kotlin que es la que componia el Frontend, no a sido una experiencia leve, sobre todo cuando
nos hacercamos a la fecha de entrega y en la que la presion se acrecenta aun mas, aunque, me gustaria resaltar que a base de golpes y desesperanza, mi confianza en mis 
habilidades tal vez, haya menjorado un poco, aunque , debido al corto periodo de tiempo de trabajo, no he podido implmentar todo lo que me gustaria, lo cual, me deja con
una pequeña sensacion de disconformidad y desazon.


