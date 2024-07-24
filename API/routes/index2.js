const express = require('express');

const dotenv = require('dotenv');

dotenv.config().parsed;
const morgan = require('morgan');
const bcryptjs=require('bcryptjs');
const bodyparser=require('body-parser');
const port = process.env.PORT || 3000;
const connectDB=require('../config/db2.js');


const app = express();

app.use(express.json({}));
app.use(express.json({
    extended: true
}));

app.use(bodyparser.json());
/*https://Localhost:3000/api/todo/auth/register*/
app.use('/api/todo/auth',require('./user.js'));
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
})

//Register
app.post("/register",async (req, res) => {
    const body = req.body;
    
    const result= await db2.create(body);

    res.status(201).json({msg: "user registered sucessfully"})
    })*/


app.listen(port, () => {
    console.log(`App listening on port ${port}!`);
    //console.log(dotenv.config());
});
connectDB();
