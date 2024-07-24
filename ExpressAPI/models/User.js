const mongoose = require('mongoose');
const bcryptjs=require('bcryptjs');

const userSchema=new mongoose.Schema({
  avatar: {
    type: String
  },
  username: {
    type: String,
    required:true
  },
  phone_no: {
    type: String,
    required:true
  },
  email: {
    type: String,
    required: true
  },
  password: {
    type: String,
    required: true
  }  
});

module.exports = mongoose.model('User', userSchema);