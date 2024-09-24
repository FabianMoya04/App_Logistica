const express = require('express');
const cors = require('cors');
const app = express();
const PORT = process.env.PORT || 8080;

// Middleware
app.use(cors());
app.use(express.json());

app.get('/', (req, res) => {
    res.send('¡Servidor en funcionamiento!');
});

app.get('/api/users', (req, res) => {

    const users = [
        { id: 1, name: 'Juan' },
        { id: 2, name: 'Ana' },
        { id: 3, name: 'Pedro' }
    ];
    res.json(users);
});

app.listen(PORT, () => {
    console.log(`Servidor escuchando en http://localhost:${PORT}`);
});
