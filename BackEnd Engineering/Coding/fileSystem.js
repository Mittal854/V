const fs = require("fs");
console.log("1");

//-------------------------------------  reading file
// const result=fs.readFileSync("read.txt","utf-8");
// console.log(result);
//------------------------------------- reading non-existing file
// fs.readFile("read34.txt","utf-8",(err,data)=>{
//     console.log(data);
// });
// console.log("2");
//------------------------------------- writing file
// fs.writeFile("write.txt", "FS module write operation", (err) => {
//   console.log("File is written");
//   console.log(err);
// });
//------------------------------------- appending file
fs.appendFile("read.txt", " Is this append?", (err) => {
  console.log("File is appended");
  console.log(err);
});