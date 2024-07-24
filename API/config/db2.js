const mongoose= require('mongoose');

/*const dotenv = require('dotenv');
dotenv.config({
    path: './config/.env'
});*/
/*const mongo_uri=process.env.MONGO_URI || 'mongodb://127.0.0.1:27017/authest';
/*mongoose
    .connect('mongo_uri')
    .then(() => console.log("Database Connected"))
    .catch(() => console.log("Error"))

//auth schema

const authSchema = new mongoose.Schema({
    email: {
        type: String,
        required: true,
        unique: true
    },
    pass: {
        type: String,
        required: true
    }
});
const auth = mongoose.model('auth', authSchema, 'creds');

module.exports=auth;*/
const connectDB = async () => {
   const conn = await mongoose.connect(process.env.MONGO_URI);
        /*{
            useNewUlParser:true,
            useCreateIndex:true,
            useFindAndModify:false,
            useUnifiedTopology:true
        });*/
        /*try{
            await mongoose.connect(process.env.MONGO_URI/* || 'mongodb://127.0.0.1:27017/authest')
            console.log("server is connected")
        }
        catch{
            console.log("server connection failed")
        }*/
        console.log("MongoDB connected: ", conn.connection.host);
}

module.exports=connectDB;