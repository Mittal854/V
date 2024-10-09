const express = require("express");
const app = express();
const bodyParser = require("body-parser");
const port = 3000;
app.set("view engine", "ejs");
app.use(bodyParser.urlencoded({ extended: true }));
const users = [
  { name: "A", age: 20 },
  { name: "B", age: 30 },
  { name: "C", age: 40 },
];



app.get("/users", (req, res) => {
  res.render("pages/user", {
    users,
  });
});
app.get("/form",(req,res)=>{
    res.render("pages/form");
})
app.post("/submit",(req,res)=>{
    const {name,message} = req.body;
    res.render("pages/result",{name,message});
})

app.listen(port, () => {
  console.log(`App listening at port ${port}`);
});
