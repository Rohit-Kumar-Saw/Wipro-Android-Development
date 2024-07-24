const mongoose=require('mongoose');

const orderSchema=new mongoose.Schema({
    productId: {type: mongoose.Schema.Types.ObjectId, ref: 'product', required:true},
    quantity: {type: Number, required: true},
    status: { type: String, required:true},
});

module.exports=mongoose.model('Order', orderSchema);