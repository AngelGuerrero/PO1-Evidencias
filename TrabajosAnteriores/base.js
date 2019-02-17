$(document).ready(function(){
  $(".button-collapse").sideNav();

  var paginaActual = window.location.href;
  if (paginaActual.includes('sobremi') || paginaActual.includes('trabajos') || paginaActual.includes('publicaciones'))
  {
    window.location.href = "/angelguerrero/";
  }


// setTimeout(function(){
//   window.location.reload(1);
// }, 30000000);

  var route = window.location.href;
  var _href = $(".target-folder").attr("href");

  if (route.includes("trabajos")) {
    $(".target-folder").text("trabajos");
    $(".target-folder").attr("href", _href + "/trabajos/");
    console.log(_href);
    console.log("trabajos");
  }
  else if (route.includes("blog")) {
    $(".target-folder").text("publicaciones");
    $(".target-folder").attr("href", _href + "/publicaciones/");
    console.log(_href);
    console.log("publicaciones");
  }

  $("section p").addClass("flow-text");

  $("#social a").hover(function(){
    $("#social a").addClass("animated shake");
  });

  $("#upBottom").click(function() {
    $('html, body').animate({
        scrollTop: $("#breadcrumb").offset().top
    }, 2000);
  });

  $(window).scroll(function (event) {
    var scroll = $(window).scrollTop();
    console.log(scroll);
    if (scroll > 1000) {
      $("#upBottom").removeClass("hide");
    }
    else {
      $("#upBottom").addClass("hide");
    }
} );


  $(".containerBreadcrumb a:last-child").attr("href", "#!");

});
