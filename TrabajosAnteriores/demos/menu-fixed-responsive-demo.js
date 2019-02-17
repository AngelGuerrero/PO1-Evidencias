$(document).ready(function() {
  // Abrir el menú lateral
  $("#mostrarMenu").click(function() {
    $("#panel-fijo-izquierdo").animate({left: "0"}, "easing");
    $("#ventana").toggle();
  });
  // Cerrar el menú lateral
  $("#regresar").click(function() {
    $("#panel-fijo-izquierdo").animate({left: "-300"}, 500);
    $("#ventana").toggle();
  });
  // Código que sirve para opacar la ventana y salir del menú lateral
  $("#ventana").click(function() {
    $("#panel-fijo-izquierdo").animate({left: "-300"}, 500);
    $("#ventana").toggle();
  });

  // Javascript y jquery no coinciden en la misma medida de la pantalla.
  // Abrir el menú fijo
  $(window).resize(function() {
    var medidaDeQuiebre = 483; // Punto en el que la pantalla sufre un bug

    var medidaArriba = $(window).width() >= medidaDeQuiebre ? "0px" : "-210px";
    document.getElementById('dom').innerHTML = $(window).width();
    $("nav").css('top', medidaArriba);

    if ($(window).width() >= medidaDeQuiebre) {
      $("#mostrarMenuAbajo").css('display', 'none');
      $("#mostrarMenuArriba").css('display', 'none');
    }
    else{
      $("#mostrarMenuAbajo").css('display', 'block');
      $("#mostrarMenuArriba").css('display', 'none');
    }
    // Si llega a la medida de quiebre
    if ($(window).width() == medidaDeQuiebre) {
      $("nav").css('top', "-210px");
      $("#mostrarMenuAbajo").css('display', 'block');
    }
  });

  // Eventos para los iconos mostrar el menú fijo
  $("#mostrarMenuAbajo").click(function() {
    $("nav").animate({top: 0}, 500);
    $(this).css('display', 'none');
    $("#mostrarMenuArriba").css('display', 'block');
  });
  $("#mostrarMenuArriba").click(function() {
    $("nav").animate({top: -210 }, 500);
    $(this).css('display', 'none');
    $("#mostrarMenuAbajo").css('display', 'block');
  });



});
