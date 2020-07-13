<h1> HospITTal </h1>
<img src=https://github.com/Ivan-LB/HospITTal/blob/master/imagenes/logo1.png
  alt="Logo del Programa"
  tittle="HospITTal"
>
<h2> ¿Qué es HospITTal? </h2>
<p>Esta es una aplicacion para un hospital que permite al usuario registrarse y agendar citas desde la comodidad de su hogar.<br>
Las funciones del servidor son simples: aceptar o rechazar a los clientes y poder revisar los expedientes de los usuarios<br></p>
<h2> ¿Que hace el programa? </h2>
<p>El programa nos abre una terminal con una pregunta <em><q>¿Es su primera vez aqui?</q></em> seguido de dos botones.<br>
<strong>Si se pulsa el boton Si</strong> nos generara la ventana de registro, en la cual se ingresa primero el usuario y la contraseña del mismo<br>
le pedira los datos para generar su historial clinico, luego esos datos son enviados al servidor y una vez en el servidor son o<br>
aceptados o rechazados si es aceptado le permitira iniciar sesion con el mismo usuario y contraseña que se introdujo al momento<br>
de hacer el registro, una vez dentro de su perfil tendra la opcion de agendar una cita con alguno de los doctores, escojiendo el<br>
dia y la hora en el que quiera agendar una cita, una vez hecho eso se le notifica al servidor el dia la hora y con quien hizo su<br>
cita, en el servidor se pueden checar los datos del paciente y las citas que tenga pendientes.<br>
<strong>Si se pulsa el boton No</strong> salta directamente al inicio de sesion</p>

<h2> Las librerias que utilizamos fueron:</h2>
<p>Para el apartado grafico</p>
<ul>
<li> Swing</li>
<li> AWT</li>
</ul>
<p>Para el manejo de archivos</p>
<ul>
<li> java.util</li>
<li> java.IO</li>
</ul>
<p>Para la creacion del servidor</p>
<ul>
<li> java.net</li>
</ul>
<h2> Iniciar el programa </h2>
<p> Siendo el cliente lo que debe hacer es abrir la cmd y posicionarse en la ruta donde descargo el proyecto y escribir lo siguiente:</p>
<blockquote> java aplicacion.cliente.IniciarCliente </blockquote>
<p> Siendo el servidor debera de abrir la cmd y posicionarse en la ruta donde descargo el proyecto y escribir lo siguiente: </p>
<blockquote> java aplicacion.servidor.IniciarServidor</blockquote>
<h2> Construido con: </h2>
<ul>
<li> <strong>SublimeText3</strong>-<em>Editor de texto</em></li>
<li> <strong>Atom</strong>-<em>Editor de texto colaborativo</em></li>
</ul>
<h2> Preview del Programa Cliente</h2>
  <img src=https://github.com/Ivan-LB/HospITTal/blob/master/Imagenes%20del%20proyecto/iniciox.JPG>
  <img src=https://github.com/Ivan-LB/HospITTal/blob/master/Imagenes%20del%20proyecto/perfil.JPG>

