const express=require('express');
const router=express.Router();
const Order=require('../models/order');

//get all orders

router.get('/',async(req, res)=>{
    try{
    const orders=await Order.find().populate('productId');
    res.json(orders);
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

//create a new order
router.post('/',async(req, res)=>{
    try{
    const order=new Order(req.body);
    await order.save();
    res.status(201).json(order);
    }
    catch(error)
    {
        res.status(400).json({error: error.message});
    }
});

//update an order
router.put('/:id',async(req,res)=>{
    try{
    const order=await Order.findByIdAndUpdate(req.params.id,req.body,{new:true});
    if(!order) return res.status(404).json({error: 'order not found'});
    res.json(order);
    }
    catch(error)
    {
        res.status(400).json({error: error.message});
    }
});

//get a specific order
router.get('/:id',async(req, res)=>{
    try{
    const order= await Order.findById(req.params.id).populate('productId');
    if(!order) return res.status(404).json({error: 'order not found'});
    res.json(order);
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

//delete a product

router.delete('/:id', async(req,res)=>{
    try{
    const order=await Order.findByIdAndDelete(req.params.id);
    if(!order) return res.status(404).json({error: 'order not found'});
    res.status(204).send();
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

module.exports=router;

