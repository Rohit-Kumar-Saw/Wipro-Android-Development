const express=require('express');
const router=express.Router();
const User=require('../models/user');
const jwt=require('jsonwebtoken');
const bcrypt= require('bcryptjs');
const config=require('../config');

router.post('/signup',async(req,res)=>{
    try{
    const{ username, password}=req.body;
    const hashedPassword=await bcrypt.hash(password, 10);
    const user=new User({username, password:hashedPassword});
    await user.save();
    res.status(201).json(user);
    }
    catch(error)
    {
        res.status(400).json({error: error.message});
    }
});

router.post('/login',async (req, res)=>{
    try{
    const {username, password }= req.body;
    const user=await User.findOne({ username});
    if(!user || await bcrypt.compare(password, user.password)){
        return res.status(401).json({error:'Invalid credentials'});
    }
        const token = jwt.sign({username: user.username}, config.jwtSecret, {expiresIn:'1h'});
        res.json({ token});
    }
    catch{
        res.status(500).json({error:error.message});
    }
});

module.exports= router;