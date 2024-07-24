const express=require('express');
const router=express.Router();
const Inventory = require('../models/inventory');

//get all inventory

router.get('/',async(req, res)=>{
    try{
    const inventory=await Inventory.find().populate('productId');
    res.json(inventory);
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

//create a new inventory entry
router.post('/',async(req, res)=>{
    try{
    const inventory=new Inventory(req.body);
    await inventory.save();
    res.status(201).json(inventory);
    }
    catch(error)
    {
        res.status(400).json({error: error.message});
    }

});

//update an inventory entry
router.put('/:id',async(req,res)=>{
    try{
    const inventoy=await Inventory.findByIdAndUpdate(req.params.id,req.body,{new:true});
    if(!inventory) return res.status(404).json({error: 'Inventory not found'});
    res.json(inventory);
    }
    catch(error)
    {
        res.status(400).json({error: error.message});
    }
});

//get a specific inventory
router.get('/:id',async(req, res)=>{
    try{
    const inventory= await Inventory.findById(req.params.id).populate('productId');
    if(!inventory) return res.status(404).json({error: 'Inventory not found'});
    res.json(inventory);
}catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

//delete an inventory entry

router.delete('/:id', async(req,res)=>{
    try{
    await Inventory.findByIdAndDelete(req.params.id);
    if(!inventory) return res.status(404).json({error: 'Inventory not found'});
    res.status(204).send();
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }

});

module.exports=router;

