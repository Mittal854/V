const express = require("express");
const users = require("./MOCK_DATA.json");
const fs = require("fs");

const app = express();
const port = 7000;

app.use(express.urlencoded({ extended: false }));

// app.get("/api/users",(req,res)=>{
//     return res.json(users)
// })

// app.get("/api/users/:id", (req, res) => {
//   const id = Number(req.params.id);
//   const user = users.find((user) => user.id === id);
//   if (user) {
//     return res.json(user);
//   }
//   return res.status(404).json({ error: "User not found" });
// });

// app.get("/users",(req,res)=>{
//   const html=`
//   <ul>
//   ${users.map(user=>`<li>${user.first_name}</li>`)}
//   <ul>`;
//   res.send(html)
// })

app.post("/api/users", (req, res) => {
  const body = req.body;
  users.push({ id: users.length + 1, ...body });
  fs.writeFile("./MOCK_DATA.json", JSON.stringify(users), (err, data) => {
    return res.json({ message: "User added successfully" });
  });
});

app.patch("/api/users/:id", (req, res) => {
  const id = Number(req.params.id);
  const body = req.body;
  const user = users.find((user) => user.id === id);
  if (user) {
    Object.assign(user, body);
    fs.writeFile("./MOCK_DATA.json", JSON.stringify(users), (err, data) => {
      return res.json({ message: "User updated successfully" });
    });
  }
});
app.delete("/api/users/:id", (req, res) => {
  const id = Number(req.params.id);
  const userIndex = users.findIndex((user) => user.id === id);
  if (userIndex !== -1) {
    users.splice(userIndex, 1);
    fs.writeFile("./MOCK_DATA.json", JSON.stringify(users), (err, data) => {
      return res.json({ message: "User deleted successfully" });
    });
  }
});
app.listen(port, () => console.log(`server started at ${port}`));
