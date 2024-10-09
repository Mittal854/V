http=require('http');
myserver=http.createServer((req,res)=>{
    res.end("hello");
})
myserver.listen(8080,()=>console.log("Server Started"));