const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');

// Initialize Express
const app = express();

// Middleware
app.use(bodyParser.json());
app.use(cors());

// Connect to MongoDB
mongoose.connect("mongodb+srv://rohit09876kumar:rtyu@cluster0.wp8ioxi.mongodb.net/Todo_List")
  .then(() => console.log('MongoDB connected...'))
  .catch(err => console.log(err));

// Define Todo schema and model
const TodoSchema = new mongoose.Schema({
    username: String,
    password: String,
});

const Todo = mongoose.model('Todo', TodoSchema);

// API Routes
app.get('/todos', async (req, res) => {
    const todos = await Todo.find();
    res.json(todos);
});

app.post('/todos', async (req, res) => {
    const todo = new Todo({
        username: req.body.username,
        password: req.body.password
    });
    await todo.save();
    res.json(todo);
});

app.put('/todos/:id', async (req, res) => {
    const { id } = req.params;
    const updatedTodo = await Todo.findByIdAndUpdate(id, req.body, { new: true });
    res.json(updatedTodo);
});

app.delete('/todos/:id', async (req, res) => {
    const { id } = req.params;
    await Todo.findByIdAndDelete(id);
    res.sendStatus(204);
});

// Start server
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
