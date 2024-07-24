const express=require('express');
const router=express.Router();
const Product=require('../models/product');

//get all products

router.get('/',async(req, res)=>{
    try{
    const products=await Product.find();
    res.json(products);
    }
    catch(error)
    {
        res.status(500).json({error:error.message});
    }
});

//create a new product
router.post('/',async(req, res)=>{
    try{
    const products=new Product(req.body);
    await product.save();
    res.status(201).json(product);

    }
    catch(error)
    {
        res.status(400).json({error:error.message});
    }
    
});

//update products
router.put('/:id',async(req,res)=>{
    try{
    const product=await Product.findByIdAndUpdate(req.params.id,req.body,{new:true});
    if(!product) return res.status(404).json({error: 'product not found'});
    res.json(product);
    }
    catch(error)
    {
        res.status(400).json({error:error.message});
    }
});

//get a specific product
router.get('/:id',async(req, res)=>{
    try{
    const product= await product.findById(req.params.id);
    if(!product) return res.status(404).json({error: 'product not found'});
    res.json(product);
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

//delete a product

router.delete('/:id', async(req,res)=>{
    try{
       const product= await Product.findByIdAndDelete(req.params.id);
       if(!product) return res.status(404).json({error: 'product not found'});
        res.status(204).send();
    }
    catch(error)
    {
        res.status(400).json({error:error.message});
    }
});

module.exports=router;

