const resultado = document.querySelector("#resultado");

// se define los operadores permitidos y las variables
const operadores = ["*", "/", "+", "-"];
const calcular = [];
let operador = "";
let nuevoNum = ""

function handleClickNum(e) {
  nuevoNum = nuevoNum + e.innerHTML;
  resultado.innerHTML = nuevoNum;
};

function handleClickOperador(e) {
  // se obtiene el operador (+, -, *, /)
  operador = e.innerHTML;
  // se guarda en el arreglo el numero y el operador
  calcular.push(nuevoNum);
  calcular.push(operador);
  //
  nuevoNum = "";
  resultado.innerHTML = operador;
}

function handleClickIgual() {
  // numNuevo tiene valor se agrega al arreglo
  if (nuevoNum !== "") calcular.push(nuevoNum);
  // si el utimo item del arreglo es un operador se elimina
  if (operador.includes(calcular[calcular.length -1])) calcular.pop();

  // desde aqui se realiza el calculo y se establece para proximo calculo
  nuevoNum = "";

  calcular.forEach(e => {
    nuevoNum = nuevoNum + e;
  });

  nuevoNum = eval(nuevoNum);
  calcular.length = 0;
  calcular.push(nuevoNum);
  resultado.innerHTML = nuevoNum;
  nuevoNum = "";
}

function handleClear() {
  calcular.length = 0;
  operador = "";
  nuevoNum = ""
  resultado.innerHTML = 0;
}