const jwt = require('jsonwebtoken');
const config=require('../config');

const authenticateJWT=(req, res, next)=>{
    const token= req.header(authorization)?.split(' ')[1];
    if(token)
    {
        jwt.verify(token, config.jwtSecret, (err,user)=>{
            if(err)
            {
                return res.sendStatus(403);
            }
            req.user=user;
            next();
        });
    }
    else{
        res.sendStatus(401);
    }
};

module.exports=authenticateJWT;