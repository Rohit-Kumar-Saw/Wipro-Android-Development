const express=require('express');
const router=express.Router();
const Supplier=require('../models/supplier');

//get all supplier

router.get('/',async(req, res)=>{
    try{
    const suppliers=await Supplier.find();
    res.json(suppliers);
    }
    catch(error)
    {
        res.status(500).json({error: error.message});
    }
});

//create a new supplier
router.post('/',async(req, res)=>{
    try{
    const supplier=new Supplier(req.body);
    await supplier.save();
    res.json(supplier);
}
catch(error)
{
    res.status(400).json({error: error.message});
}
});

//update supplier
router.put('/:id',async(req,res)=>{
    try{
    const supplier=await Supplier.findByIdAndUpdate(req.params.id,req.body,{new:true});
    if(!supplier) return res.status(404).json({error: 'Supplier not found'});
    res.json(supplier);
    }
catch(error)
{
    res.status(400).json({error: error.message});
}
});

//get a specific supplier
router.get('/:id',async(req, res)=>{
    try{
    const supplier= await Supplier.findById(req.params.id);
    if(!supplier) return res.status(404).json({error: 'Supplier not found'});
    res.json(supplier);
}
catch(error)
{
    res.status(500).json({error: error.message});
}
});

//delete a supplier

router.delete('/:id', async(req,res)=>{
    try{
    const supplier=await Supplier.findByIdAndDelete(req.params.id);
    if(!supplier) return res.status(404).json({error: 'Supplier not found'});
    res.Status(204).send();
}
catch(error)
{
    res.status(500).json({error: error.message});
}
});

module.exports=router;

