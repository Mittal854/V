// const fs = require("fs");
// fs.writeFile("hello.txt","Hello World",(err)=>{
//     if(err) throw err;
//     console.log("File Created");
// })
// fs.appendFile("hello.txt", "  hiiiii", (err) => {
//   if (err) throw err;
//   console.log("data appended");
// });
// fs.rename("hello.txt","hi.txt",(err)=>{
//     if(err) throw err;
//     console.log("File Renamed");
// })
// fs.copyFile("hi.txt","copy.txt",(err)=>{
//     if(err) throw err;
//     console.log("File Copied");
// })
// fs.unlink("copy.txt",(err)=>{
//     if(err) throw err;
//     console.log("File Deleted");
// })


const http=require("http");
const server=http.createServer((req,res)=>{
    res.end("Hello World");
})
server.listen(3000);