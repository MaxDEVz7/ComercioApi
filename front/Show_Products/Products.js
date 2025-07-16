async function fetchData() {
    try {
        const response = await fetch('http://localhost:3001/api/Products');
        if (!response.ok) {
            throw new Error(`Erro ao acessar dados: ${response.statusText}`);
        }
        const data = await response.json();

        const tableBody = document.getElementById('data-table');

        data.forEach(item => {
            const row = document.createElement('tr');

            row.innerHTML = `
                <td>${item.id}</td>
                <td>${item.product}</td>
                <td>${item.price}</td>
                <td>${item.supplier.supplier}</td>
                <td>${item.saller.saller}</td>
            `;

            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Erro ao buscar dados:', error);
    }
}

function filterTable() {
    const filterId = document.getElementById('filter-id').value.toLowerCase();
    const filterProduct = document.getElementById('filter-product').value.toLowerCase();
    const filterPrice = document.getElementById('filter-price').value.toLowerCase();
    const filterSupplier = document.getElementById('filter-supplier').value.toLowerCase();
    const filterSaller = document.getElementById('filter-saller').value.toLowerCase();

    const table = document.getElementById('data-table');
    const rows = table.getElementsByTagName('tr');

    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        const id = cells[0].textContent.toLowerCase();
        const product = cells[1].textContent.toLowerCase();
        const price = cells[2].textContent.toLowerCase();
        const supplier = cells[3].textContent.toLowerCase();
        const saller = cells[4].textContent.toLowerCase();

        if (id.includes(filterId) && product.includes(filterProduct) && price.includes(filterPrice) && supplier.includes(filterSupplier) && saller.includes(filterSaller)) {
            rows[i].style.display = '';
        } else {
            rows[i].style.display = 'none';
        }
    }
}

document.getElementById('button-cadastrar').addEventListener('click', function() {
    window.location.href = "http://127.0.0.1:5500/front/SaveProduct/saveProduct.html";
});

fetchData();