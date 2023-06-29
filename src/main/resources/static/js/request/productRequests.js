$("a[title='Productos']").click(function (event) {
  event.preventDefault();
  const id = $(this).attr("data-card");
  console.log("click");
  var rows = "";
  $.ajax({
    url: "/ProductosPedidos/" + id,
    success: function (contenido) {
      console.log(contenido);
      for (var i = 0; i < contenido.length; i++) {
        rows +=
          "<tr>" +
             "<td><img src="+contenido[i][0] +" class='img-thumbnail rounded-0'></td>" +
             "<td style='text-align: left'>"+contenido[i][1] +"</td>" +
             "<td>"+'S/. ' + contenido[i][2]+"</td>"+
             "<td>"+ contenido[i][3]+"</td>"+
             "<td>"+ "S/. "+contenido[i][2]*contenido[i][3]+"</td>"+
          "</tr>";
        $("#table-products tbody").html(rows);
      }
    },
    error: function (xhr, status, error) {
      console.error(error);
    },
  });
});