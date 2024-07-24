const mongoose=require('mongoose');

const supplierSchema=new mongoose.Schema({
    name: { type: String, required: true},
    contactInfo: {type: String}
});

module.exports=mongoose.model('Supplier', supplierSchema);