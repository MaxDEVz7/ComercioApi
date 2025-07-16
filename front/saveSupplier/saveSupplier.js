document.getElementById('phone').addEventListener('input', function (e) {
    let x = e.target.value.replace(/\D/g, '').match(/(\d{0,2})(\d{0,1})(\d{0,4})(\d{0,4})/);
    e.target.value = !x[2] ? x[1] : '(' + x[1] + ') ' + x[2] + ' ' + x[3] + (x[4] ? '-' + x[4] : '');
    
    /*.replace(/\D/g, ''): Remove todos os caracteres que não são dígitos (\D significa "não dígito") do valor do campo de entrada. O g no final indica que a substituição deve ser feita globalmente, ou seja, em todas as ocorrências.
    
    .match(/(\d{0,2})(\d{0,5})(\d{0,4})/): Aplica uma expressão regular ao valor filtrado para separar os dígitos em três grupos:
    
    (\d{0,2}): O primeiro grupo captura de 0 a 2 dígitos.
    (\d{0,5}): O segundo grupo captura de 0 a 5 dígitos.
    (\d{0,4}): O terceiro grupo captura de 0 a 4 dígitos.
    */
});



document.getElementById('cnpj').addEventListener('input', function (e) {
    let x = e.target.value.replace(/\D/g, '').match(/(\d{0,2})(\d{0,3})(\d{0,3})(\d{0,4})(\d{0,2})/);
    e.target.value = !x[2] ? x[1] : x[1] + '.' + x[2] + '.' + x[3] + (x[4] ? '/' + x[4] : '') + (x[5] ? '-' + x[5] : '');
});

document.getElementById('cpf').addEventListener('input', function (e) {
    let x = e.target.value.replace(/\D/g, '').match(/(\d{0,3})(\d{0,3})(\d{0,3})(\d{0,2})/);
    e.target.value = !x[2] ? x[1] : x[1] + '.' + x[2] + '.' + x[3] + (x[4] ? '-' + x[4] : '');
});

function toggleDocumentFields() {
    const documentType = document.getElementById('documentType').value;
    const cnpjField = document.getElementById('cnpj');
    const cpfField = document.getElementById('cpf');
    
    if (documentType === 'cpf') {
        cnpjField.disabled = true;
        cpfField.disabled = false;
        cpfField.required = true;
        cnpjField.required = false;
        cnpjField.value = null;
    } else {
        cnpjField.disabled = false;
        cpfField.disabled = true;
        cpfField.required = false;
        cnpjField.required = true;
        cpfField.value = null;
    }
}

function clearFields() {
    document.getElementById('supplier').value = null;
    document.getElementById('address').value = null;
    document.getElementById('phone').value = null;
    document.getElementById('cnpj').value = null;
    document.getElementById('cpf').value = null;
    document.getElementById('UF').value = null;
    document.getElementById('documentType').value = 'Selecione o tipo do Fornecedor';
}


document.getElementsByClassName('btn')[0].addEventListener('click', function(saveSaller) {
    
    const supplier = document.getElementById('supplier').value;
    const uf = document.getElementById('UF').value;
    const address = document.getElementById('address').value;
    const phone = document.getElementById('phone').value;
    const documentType = document.getElementById('documentType').value;
    const cnpj = document.getElementById('cnpj').value;
    const cpf = document.getElementById('cpf').value;

    if(documentType === 'cnpj') {
    var data = {
        supplier: supplier,
        address: address,
        phone: phone,
        cnpj: cnpj,
        uf: uf,
    };
    }

    else if(documentType === 'cpf') {
    var data = {
        supplier: supplier,
        address: address,
        phone: phone,
        cpf: cpf,
        uf: uf,
    };
    }


    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phonePattern = /^\(\d{2}\) \d{1} \d{4}-\d{4}$/;
    const cnpjPattern = /^\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2}$/;
    const cpfPattern = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    
    if (!emailPattern.test(address)) {
        alert('Por favor, insira um endereço de email válido.');
        return console.error('Erro:', 'Endereço de email inválido.');
    }
    
    if (!phonePattern.test(phone)) {
        alert('Por favor, insira um telefone válido no formato (XX) XXXXX-XXXX.');
        return console.error('Erro:', 'Telefone inválido.');
    }

    if (documentType === 'cnpj' && !cnpjPattern.test(cnpj)) {
        alert('Por favor, insira um CNPJ válido no formato XX.XXX.XXX/XXXX-XX.');
        return console.error('Erro:', 'CNPJ inválido.');
    }

    if (documentType === 'cpf' && !cpfPattern.test(cpf)) {
        alert('Por favor, insira um CPF válido no formato XXX.XXX.XXX-XX.');
        return console.error('Erro:', 'CPF inválido.');
    }


    console.log(data);
    
    fetch('http://localhost:3001/api/saveSupplier', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert('Fornecedor cadastrado com sucesso!');
    })
    .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao cadastrar fornecedor.');
    });
    clearFields();
});
