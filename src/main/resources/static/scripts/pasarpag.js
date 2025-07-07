
    let currentPage = 1;
    const pageSize = 2;
    const pedidos = document.querySelectorAll('.lista-pedidos');
    const totalPages = Math.ceil(pedidos.length / pageSize);

    function showPage(page) {
        pedidos.forEach((pedido, index) => {
            pedido.style.display = (index >= (page - 1) * pageSize && index < page * pageSize) ? 'block' : 'none';
        });
        document.getElementById('page-info').innerText = `Página ${page} de ${totalPages}`;
    }

    function nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
            showPage(currentPage);
        }
    }

    function prevPage() {
        if (currentPage > 1) {
            currentPage--;
            showPage(currentPage);
        }
    }

    // Mostrar primera página al cargar
    document.addEventListener('DOMContentLoaded', () => showPage(currentPage));
