import express from 'express';
const app=express();
const port=process.env.PORT || 3001;
import web from './routes/web.js';

//template engine
app.set('view engine','ejs');

//static files
app.use(express.static('public'));

//load routes
app.use("/",web);

app.listen(port,()=>{
    console.log(`Server is running on port ${port}`);
});