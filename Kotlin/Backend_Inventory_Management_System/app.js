const express=require('express');
const mongoose=require('mongoose');
const productRoutes=require('./routes/product');
const inventoryRoutes=require('./routes/inventory');
const orderRoutes=require('./routes/order');
const supplierRoutes=require('./routes/supplier');
const userRoutes=require('./routes/user');
const authenticateJWT=require('./middleware/authenticateJWT');
require('dotenv').config();

const app=express();
app.use(express.json());

const connectMongoDB=process.env.MONGO_URI;
mongoose.connect(connectMongoDB)
.then(() => console.log('MongoDB connected..'))
.catch(err => console.error('MongoDB connection error:', err));

app.use('/products',authenticateJWT,productRoutes);
app.use('/inventory',authenticateJWT,inventoryRoutes);
app.use('/orders',authenticateJWT,orderRoutes);
app.use('/suppliers',authenticateJWT,supplierRoutes);
app.use('/users',userRoutes);

const PORT = process.env.PORT || 3000;
app.listen(PORT, ()=>{
    console.log(`Inventory management system backend is running on port ${PORT}`);
});