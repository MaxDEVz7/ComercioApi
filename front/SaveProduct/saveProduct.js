let suppliers = [];
let sallers = [];
document.getElementsByClassName('btn')[0].addEventListener('click', saveProduct);

document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:3001/api/Suppliers')
        .then(response => response.json())
        .then(data => {
            suppliers = data;
            console.log(suppliers);
            updateSelectors();
        });
        
    fetch('http://localhost:3001/api/Sallers')
        .then(response => response.json())  
        .then(data => {
            sallers = data;
            console.log(sallers);
            updateSelectors();
        });
    });
    

function updateSelectors() {
    const displayType = document.getElementById('displaySelect').value;
    
    const supplierSelect = document.getElementById('supplierSelect');
    supplierSelect.innerHTML = '';
    suppliers.forEach(supplier => {
        const option = document.createElement('option');
        option.value = supplier.id;
        option.text = displayType === 'id' ? supplier.id : supplier.supplier;
        supplierSelect.add(option);
    });
    
    const sallerSelect = document.getElementById('sallerSelect');
    sallerSelect.innerHTML = '';
    sallers.forEach(saller => {
        const option = document.createElement('option');
        option.value = saller.id;
        option.text = displayType === 'id' ? saller.id : saller.saller;
        sallerSelect.add(option);
    });
}

function saveProduct() {
    const productName = document.getElementById('productName').value;
    const productPrice = document.getElementById('productPrice').value;

    const product = {
        product: productName,
        price: parseFloat(productPrice),
        supplier: null,
        saller: null,
    };

    const supplierSelect = document.getElementById('supplierSelect').value;
    const sallerSelect = document.getElementById('sallerSelect').value;

    Promise.all([
        fetch('http://localhost:3001/api/Supplier/' +supplierSelect)
            .then(response => response.json())
            .then(data => product.supplier = data),
        
        fetch('http://localhost:3001/api/Saller/'+sallerSelect)
            .then(response => response.json())
            .then(data => product.saller = data)
    ])
    .then(() => {
        console.log('Produto com dados de supplier e saller:', product);

        return fetch('http://localhost:3001/api/saveProduct', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(product)
        });
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao salvar produto');
        }
        return response.json();
    })
    .then(data => {
        alert('Produto cadastrado com sucesso!');
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao cadastrar o produto.');
    });
}
