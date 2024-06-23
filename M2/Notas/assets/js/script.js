$("#btnNotasHTML").click((e) => {
  calcular("HTML");
});

$("#btnNotasCSS").click((e) => {
  calcular("CSS");
});

$("#btnNotasJS").click((e) => {
  calcular("JavaScript");
});

function calcular(materia) {
  const nota1 = prompt(`Ingrese nota 1 [${materia}]`, "");
  const nota2 = prompt(`Ingrese nota 1 [${materia}]`, "");
  const nota3 = prompt(`Ingrese nota 1 [${materia}]`, "");

  const promedio = (eval(nota1) + eval(nota2) + eval(nota3)) / 3;

  const html = `
  <tr>
    <th scope="row">${materia}</th>
    <td>${nota1}</td>
    <td>${nota2}</td>
    <td>${nota3}</td>
    <td>${promedio}</td>
  </tr>`

  $(html).appendTo($(".table-group-divider"));
};

