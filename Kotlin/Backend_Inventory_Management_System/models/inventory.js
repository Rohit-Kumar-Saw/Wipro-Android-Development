const mongoose=require('mongoose');

const inventorySchema=new mongoose.Schema({
    productId: {type: mongoose.Schema.Types.ObjectId, ref: 'product', required:true},
    quantity: {type: Number, required: true},
    location: {type: String, required:true,}
});

module.exports=mongoose.model('Inventory', inventorySchema);