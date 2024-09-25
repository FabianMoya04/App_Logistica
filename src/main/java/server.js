const express = require('express');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

app.get('/api/users', (req, res) => {
    res.json([{ id: 1, name: 'Juan' }, { id: 2, name: 'Ana' }]);
});

app.listen(8080, () => {
    console.log('Server is running on http://localhost:8080');
});
