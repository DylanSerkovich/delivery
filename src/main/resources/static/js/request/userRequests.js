const Toast = Swal.mixin({
  toast: true,
  position: "top-end",
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener("mouseenter", Swal.stopTimer);
    toast.addEventListener("mouseleave", Swal.resumeTimer);
  },
});


$(function () {
  $("#form_register").submit(function (e) {
    //Prevent default submission of form
    e.preventDefault();

    //Remove previous errors

    $("input").next(".invalid-tooltip").remove();
    //$("#create_account").prev(".validationLogin-message").remove();

    Swal.fire({
      title: "Comprobando...",
      html: "Espere un momento",
      icon: 'info',
      showCancelButton: false,
      showConfirmButton: false,
      showCloseButton: false,
      allowEscapeKey: false,
      allowOutsideClick: false,
      willOpen: () => {
        Swal.showLoading()
      },
    });
    var url = window.location.origin;
    $.ajax({
      url: url + "/registrate",
      //url: "/registrate",
      type: "POST",
      data: $("#form_register").serialize(),
      success: function (res) {
        console.log(res);
        Swal.close();


        if (res.validated) {

          if (res.exists) {
            $("#create_account").before(
              '<div  class="validationLogin-message" style="grid-column: 1 / -1;">El correo de usuario ya esta registrado</div>'
            );
          } else {
            /*
            $(".modal-button-close").click();
            //$('input').not(":submit").val('');
            $("#form_register").find("input").not(":submit").val("");
            $("input").removeClass("non-empty");
            Toast.fire({
              icon: "success",
              title:
                "<center>!Se Registró Correctamente!</center><center>¡Ingrese a su correo para verificar su cuenta!</center>",
            });*/
            window.location.href = "/login_cliente";
          }
        } else {
          $.each(res.errorMessages, function (key, value) {
            console.log(key, value);
            $("input[name="+"'" + key+"'" + "]").after(
              '<div class="invalid-tooltip">' + value + "</div>"
            );
            //alert("Registration not Successful");
          });
        }
      },
      error: function (error){
        /*Swal.close();
        Toast.fire({
          icon: "error",
          title:
            "<center>!Hubo un error al registrar!</center><center>¡Porfavor Intentelo denuevo!</center>",
        });*/
      }
    });
  });
});