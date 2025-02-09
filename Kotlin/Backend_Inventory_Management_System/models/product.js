const mongoose = require('mongoose');

const productSchema=new mongoose.Schema({
    name: {type:String, require: true},
    description:{ type: String},
    price:{type: Number, required: true},
    quantity: {type: Number, required: true}
});

module.exports=mongoose.model('product', productSchema);