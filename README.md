# Enlaza Proyect - Open Canarias
This project has been developed for the Open Canarias company, as it is already summarized in the name itself, the summarized idea of ​​the application is that a anyone can make a reservation for a hotel room.

 ## Table of Contents
1. [Pre Requisites](#pre-requisites)
2. [Data model](#data-model)
3. [Entity Relationship](#entity-relationship)
4. [Model Relationship](#model-relationship)
5. [User requirements](#user-requirements)
6. [Use cases](#use-cases)
7. [Enlaza Project Prototype](#enlaza-project-prototype)
8. [User manual](#user-manual)
9. [Technology Stack](#technology-stack)
10. [Technology Comparison](#technology-comparison)
11. [Repositories](#repositories)
12. [Planification](#planification)
13. [Conclusions and opinions](#conclusions-and-opinions)

## Pre Requisites
### First Steps 📋
When you download or clone this repository, the first thing you should do is run the following command in the direction of the project
```
composer install
```
### Migrations ⚙️
Then you must take into account the configuration of the DB in the .env file. Then you should create a migration with the following command:
```
php artisan migrate
```
You should also take into account other existing commands if you modify or eliminate something from the migrations:
```
php artisan migrate:rollback
php artisan migrate
```
And you are ready to start the Android app, but first you should be sure to open your command console and type the following command
```
ipconfig
```
Once you are clear about what IP your computer is using, you should go to the terminal and go to the backend folder, and then execute the following

```
php -S (YOUR_IP):8000 -t public
```
Now you should go to the IRetroFit file and ServiceSingleton to modify the ip previously established by me to yours

## Data model
The data model follows the following description or structure:
* **Users Table:** This table will be where we find the data to predispose to make the record.
  * **Name:** User name
  * **Email** User Email
  * **Password** User Password
  
* **Rooms Table:** This table will be where we find the data that the users of the rooms see.
  * **Number:** Room number
  * **Name:** Room name
  * **Subname:** Room number
  * **Description:** Room description
  * **Numperson:** Number of people who can occupy the room
  * **Size:** Room size
  * **Price:** Room price
  * **Starating:** Number of evaluations
  * **Url_img:** Room image
  
* **Bookings Table:** This table will be where we will find the data that you will have to give to develop the reservation.
  * **Check_in:** Check in
  * **Check_out** Check out
  * **Diet** Booking plan type
  * **id_user** Id User Reservation (FK user table)
  * **id_room** Id of the reserved room (FK room table)
  
## Entity Relationship
<img src="doc/img/entidadrelacion.png" alt="Entidad Relacion" width="750px" height="400px" />

## Model Relationship
<img src="doc/img/modelorelacional.png" alt="Entidad Relacion" width="750px" height="400px" />

## User requirements
The user requirements can be defined as follows:
* **R1.** Platform.
    * **R1.1.** The app that we will make will be for Mobile.
    * **R1.2.** There is no previous application to take references.
* **R2.** Only the functions that are broken down from the two cruds performed in the app will be implemented.
* **R3.** Users will have to access by registering, providing their name, email and password.
* **R4.** Once inside the main activity, they will be able to direct the different ones.
  * **R4.1.** The user will be able to logout, by clicking on the button on the top left.
  * **R4.2.** The user can access the user's profile by clicking on the upper right button.
  * **R4.3.** If you click on any of the rooms you will go to it in detail.
* **R5.** Once inside the part of the user's profile you can contemplate the following possibilities:
  * **R5.1.** If you click on the one in the upper center, you can go to the user's edition.
  * **R5.2.** If you click on the upper right button you will delete the user.
  * **R5.3.** Then in the lower center you will find a series of cards where you will view the user's reservations.
    * **R5.3.1.** If you click on them you can go to the form to update them.
    * **R5.3.2.** If you click on the crosshead button, you will delete it.
* **R6** Once inside the part of the rooms in detail it will be necessary to take into account:
  * **R6.1.** If you click on the lower right button, you will go to the form where you can create the reservation for the user with whom you have logged in and for the habotacopn, with the data specified therein.
  * **R6.2.** The form will validate that it does not let you mark days before the current day or after 30 days.

## RelationShips
A user can only book a room that's available A user can book many rooms.
A room can only be reserved by one user, as long as it is on a specific date.

## Use cases
<img src="doc/img/casosdeuso.png" alt="Entidad Relacion" width="750px" height="400px" />

## Explanation of the Application
The application follows the architecture of the prototype provided as far as possible. That is, what is composed of the screens themselves:

* **Start Window:** In this window we can find a simple starting window of any application

<img src="doc/img/home.png" alt="Imagen3" width="200px" height="400px" />

* **Login or registration form:** In this window you will have to register, or in case you already have an account, simply enter your identifying information and enter.

* **Discover window:** In this window you must select between the different destinations to select.

<img src="doc/img/main.png" alt="Imagen7" width="200px" height="400px" />

* **User window:** In this window you will see data such as the name of the user and the reservations generated by the same.

<img src="doc/img/userprofile.png" alt="Imagen7" width="200px" height="400px" />

* **Detail Room window:** You will see the specific room, in which you had played the last time.

<img src="doc/img/main.png" alt="Imagen7" width="200px" height="400px" />

* **Reserve or Update Reserve windows:** In these windows you will see a form where you can carry out the specific actions of each of the windows.
<img style="float: right;" src="doc/img/reserve.png" alt="Reservation" width="200px" height="400px" />
<img style="float: right;" src="doc/img/update.png" alt="Update" width="200px" height="400px" />

## Enlaza Project Prototype

I describe this section in its corresponding repository, https://github.com/JavierMedina11/Prototipo-ProyectoEnlaza

## User manual
[Manual Español](https://github.com/JavierMedina11/OpenCanarias_EnlazaProject/blob/main/doc/Documentacion%20Eng.pdf)

[English Manual](https://github.com/JavierMedina11/OpenCanarias_EnlazaProject/blob/main/doc/Documentacion%20Esp.pdf)

## Technology Stack
The technology stack is divided into the following technologies:

* **Backend:** PHP 7 / Laravel Framework
* **Microservicio:** Lumen Framework
* **BBDD:** MySQL
* **Frontend:** Android Kotlin


## Technology Comparison
As for the technology comparison, I would like to get to the point and compare the programming in native or hybrid App's, since they are the ones I have had the pleasure of working with. As for these two, I would like to emphasize that both have their advantages and disadvantages.

Even so, I will try to expose it much more clearly:
* **Time-to-market of the initial development / add and adjust a new functionality:** In the case of hybrid applications it is not necessary to maintain two different technologies and two different base codes, so with the same resources we can produce new features faster.
* **User experience:** While it is true that with current technologies, it is possible to create a user experience very similar to a native one, in some old terminals, the performance and therefore the user experience may be somewhat lower, therefore it is common for the application to flow better when it is 100% native.
* **Simplicity / Reuse of code:** The code of a hybrid application is portable to other platforms with minimal complexity, as long as they have support for said applications (Android Auto, Android Tv, etc). In addition, the existence of a single code for the base application, despite the fact that there may be specific customizations for each platform, gives a clear advantage to the hybrid application.
* **Look & Feel of the application:** It was always easier since the compatibility with CSS, which hybrid applications have, gives it a clear advantage in this regard, it should be noted that the native ones have a large number of libraries with which to get this "Look & Feel".
* **Development cost:** In native applications, by having to generate a different code for each platform, development costs grow in proportion to the number of platforms on which the developed application will be available.

In conclusion, for me there are two key elements that we identify in almost all the projects we face: time and money. In the case of hybrid applications, both the time-to-market (initial and evolutionary) and the costs are lower, therefore it is presented as a very good option for the development of App's that do not make use of elements such as 3D graphics , super-intensive use of CPU or have a direct link with hardware elements such as thermal cameras, NFC readers, etc.

### Web Aps

At the same time, highlight the app webs. They are accessed directly from the browser of the phone or tablet, and in almost all devices it will be opened in almost the same way thanks to the use of Responsive Web Design. It is the simplest and most economical option, since it reduces development costs. Compatibility, usability and simplicity are among its advantages.

### PWAs or Progressive Web App

PWAs are commonly defined as Apps that bring together the best of web and native applications, even coming to be understood as a middle ground or an evolved form. Among its advantages we find:
* **Responsive:** Currently, most websites have a responsive design that allows them to adapt to different devices, something essential with the predominant role of smartphones.
* **Actualizada:** The PWAs will always show their latest version to the user, with the use of automatic updates, constantly and instantaneously and without the need to download them. This is possible thanks to the use of Service Workers and because it is still a web App, independent of the publication (and the entire process of revision and installation by the user that it entails) in the application markets.
* **Segura:** The secure HTTPS protocol is always used, which is also necessary for the Service Worker installation.
* **Offline:** A PWA must allow access, either partially or even totally, despite the fact that there is no Internet connection (or it is of low quality).
* **Multiplataforma:** In its development, the technology used contemplates its execution on various devices, operating systems and browsers. This, in addition to being key when it comes to offering a satisfactory user experience and reaching more potential audiences, makes it easier for developers and reduces costs, since differentiated programming is not required (something that does happen with native Apps) .
* **Indexable y enlazable:** The content of a PWA is trackable and indexable, so that it can appear as a result in a search engine. In addition, it can be shared using a URL, with the possibility that the other person uses it without installing it.

### Power Apps

On many occasions, it is for a company to find a solution that is specifically tailored to its needs and if it does find it, the time factor may be the reason that profit maximization is not achieved immediately. By integrating the Power Apps tool into your organization, you can solve this problem by creating custom applications from your company and for your company. By doing so they will enjoy benefits such as:
* **Wide availability:** The development platform, Power Apps, is available with an Office 365 subscription. This service is widely available; so you can create apps of different types to integrate them on various platforms.
* **Better data integration:** If your company uses Microsoft's Common Data Service (CDS), Power Apps will allow access to business data; from more than 200 different data sources such as Outlook, OneDrive, PowerPoint, Excel, SharePoint, Dynamics 365, Salesforce, Dropbox, among others.
* **Automated functions:** With the integration of Power Apps, companies can automate their processes and functions, leaving aside the manual entry of certain data. You can also send relevant updates and data to workers and buyers directly to their smartphones via push notifications.
* **Guaranteed security:** With the integration of Power Apps in the company, you have full control of the applications through the administration center.
* **Higher productivity:** By being able to create applications to meet the needs of the company and automate processes, greater productivity is achieved. Employees save time by not having to perform manual tasks and better optimize their time to dedicate to tasks of greater relevance to the company.

## Repositories

The repositories we find this same one and that of https://github.com/JavierMedina11/Prototerapia-ProyectoEnlaza

## Planification

The planning of the app, I have had to do it on the fly, that is, since I obtained the information from the company with such a delay, I have had to make an effort to try to do everything in a period of three or three and a half weeks.

## Conclusions and opinions

My final conclusion regarding the project is that it has not been easy, since when working with a technological stack in which I had no experience, especially, not so much the backend (Laravel & Lumen), but Android Studio based on Kotlin which is the one that made up the Frontend, it has not been a mild experience, especially when we get to the delivery date and in which the pressure increases even more, although, I would like to highlight that based on blows and despair, my Confidence in my abilities may have improved a bit, although, due to the short period of time at work, I have not been able to implement everything that I would like, which leaves me with a small feeling of discomfort and unease.



