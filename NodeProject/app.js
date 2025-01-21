const express = require('express');
const axios = require('axios');
require('dotenv').config();

const app = express();
const port = process.env.PORT || 3000;

app.get('/list', async (req, res) => {
    try {
        const apiUrl = process.env.API_URL;
        const page = req.query.page || 0; 
        
        const response = await axios.get(apiUrl, {
            params: { page }
        });
        const { content: products, totalPages, number: currentPage } = response.data;

        if (Array.isArray(products)) {

            const productListHtml = products.map(product => {
                return `
                    <div style="margin: 10px 0; font-family: Arial, sans-serif;">
                        <span style="color: white; background-color: black; padding: 5px;">${product.name}</span>
                        <span style="color: red; margin-left: 10px;">(${product.category})</span>
                    </div>
                `;
            }).join('');

            // Navegação entre páginas
            const navigationHtml = `
                <div style="margin-top: 20px;">
                    ${currentPage > 0 ? `<a href="/list?page=${currentPage - 1}" style="color: #00f; margin-right: 10px;">&laquo; Página Anterior</a>` : ''}
                    ${currentPage < totalPages - 1 ? `<a href="/list?page=${currentPage + 1}" style="color: #00f;">Próxima Página &raquo;</a>` : ''}
                </div>
            `;

            const htmlTemplate = `
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Product List</title>
                    <style>
                        body {
                            background-color: #202020;
                            color: #fff;
                            padding: 20px;
                            font-family: Arial, sans-serif;
                        }
                        .container {
                            max-width: 800px;
                            margin: auto;
                            border: 1px solid #fff;
                            padding: 20px;
                            border-radius: 10px;
                            background-color: #303030;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>Product List</h1>
                        ${productListHtml}
                        ${navigationHtml}
                    </div>
                </body>
                </html>
            `;

            res.send(htmlTemplate);
        } else {
            console.error("A resposta não contém um array na chave 'content'.", response.data);
            res.status(400).send('Formato de dados inválido na resposta da API.');
        }
    } catch (error) {
        console.error('Erro ao consumir a API:', error.message);
        res.status(500).send('Erro ao buscar os dados da API.');
    }
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
