$(document).ready(function() {
  var x = $("nav").find(".activo").text();
  document.getElementById('dom').innerHTML = x;
  // Al hacer click, en "nav a"
  $("nav a").click(function() {
    // Encuentra en 'nav', la clase '.activo' y quítala.
    $("nav").find(".activo").removeClass("activo");
    // Del click dado de "nav a", agrega la clase ".activo"
    $(this).addClass("activo");
    document.getElementById('dom').innerHTML = $(this).text();
  });
});
