const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

$("#enviarCorreo").click(() => {
  alert("El correo fue enviado correctamente...");
});

$("h4").on( "dblclick", function() {
  $(this).css('color', 'red');
});

$('.card-title').click(function(){
  $(this).siblings(".card-text").toggle();
});