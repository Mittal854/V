const path=require("path");
console.log(path.dirname("path.js"));
console.log(path.extname("path.js"));
console.log(path.basename("path.js"));
console.log(path.parse("path.js"));
const par=path.parse("path.js");
console.log(par.name);