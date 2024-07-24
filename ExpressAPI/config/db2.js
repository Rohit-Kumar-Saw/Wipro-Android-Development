

const mongoose = require('mongoose');
dotenv.config({path: './config/config.env'});

const connectDB = async () => {
   const conn = await mongoose.connect(process.env.MONGO_URI);
      /*  {
                useNewUrlParser:true,
                useCreateIndex: true,
                useFindAndModify: true,
                useUnifiedTopology: true
        });*/

      
        console.log("MongoDB connected: ", conn.connection.host);
}

module.exports=connectDB;