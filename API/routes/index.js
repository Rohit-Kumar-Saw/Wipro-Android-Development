const express = require('express')
/*const{getTodoById, getAllTodo}=require('./db')*/
const getTodoById=require('./db')
const Todo=require('./todo')
app.use(bodyparser.json());
app.get('/', (req, res) => res.send('Hello World!'))
app.get('/', (req, res) => res.send('Hello World!'))

app.get('/about', (req, res) => res.send("About page"))

//TODO --> Task manager
// Get All Todos
app.get('/all', (req, res) => {
    const id= req.params.id;
    const todos=getAllTodo();

    res.json({
        data:todos,
        msg:"Success"
    })
})
//Get a todo
app.get('/todo/:id', (req, res) => {
    const id= req.params.id;
    const todo=getTodoById(id);

    res.json({
        data:todo,
        msg:"Success"
    })
})
//Login

/*app.post("/login", async (req, res) => {
    const body=req.body;
    const email=body.email;
    const pass= body.pass;

    const result= await db2.find({"email": email,"pass":pass});

    if(result.length==1){
        res.json({msg:"Login successfull", status:200})
    }else{
        res.json0({msg: "Login Failed", status:400})
    }
})*/
//Register
/*app.post("/register",async (req, res) => {
    const body = req.body;
    
    const result= await db2.create(body);

    res.status(201).json({msg: "user registered sucessfully"})
    })*/
    app.listen(port, () => console.log(`App listening on port ${port}!`));