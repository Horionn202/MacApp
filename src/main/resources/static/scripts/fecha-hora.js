function actualizarFechaHora() {
    const ahora = new Date();

    // Formatear fecha: dd/mm/yyyy
    const dia = String(ahora.getDate()).padStart(2, '0');
    const mes = String(ahora.getMonth() + 1).padStart(2, '0');
    const anio = ahora.getFullYear();
    const fechaFormateada = `${dia}/${mes}/${anio}`;

    // Formatear hora: hh:mm:ss
    const horas = String(ahora.getHours()).padStart(2, '0');
    const minutos = String(ahora.getMinutes()).padStart(2, '0');
    const segundos = String(ahora.getSeconds()).padStart(2, '0');
    const horaFormateada = `${horas}:${minutos}:${segundos}`;

    // Asignar a los elementos con id 'fecha' y 'hora'
    const fechaElem = document.getElementById('fecha');
    const horaElem = document.getElementById('hora');
    if (fechaElem) fechaElem.textContent = fechaFormateada;
    if (horaElem) horaElem.textContent = horaFormateada;
}

// Actualizar cada segundo
setInterval(actualizarFechaHora, 1000);
// Llamar una vez al cargar
actualizarFechaHora();