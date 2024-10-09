
const express = require("express");
const mongoose = require("mongoose");
const path = require("path");
const app = express();

const Account = require("./models/Account");

const url =
  "mongodb+srv://bhuveshmittal854:bhuvesh@cluster0.i7hhkfd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static("public"));

mongoose
  .connect(url, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => {
    console.log("Connected to database");
  })
  .catch((err) => {
    console.log("Some issue while connecting to the database", err);
  });

// Route for signup
app.post("/signup", (req, res) => {
  const { username, password } = req.body;

  const newAccount = new Account({
    username: username,
    password: password,
  });

  newAccount
    .save()
    .then(() => {
      res.redirect("/login");
    })
    .catch((err) => {
      console.error("Error creating account:", err);
      res.status(500).send("Internal Server Error");
    });
});

// Route for login
app.post("/login", (req, res) => {
  const { username, password } = req.body;

  Account.findOne({ username: username, password: password })
    .then((account) => {
      if (account) {
        res.sendFile(path.join(__dirname, "public", "successful.html"));
        
      } else {
        res.status(401).send("Invalid username or password");
      }
    })
    .catch((err) => {
      console.error("Error during login:", err);
      res.status(500).send("Internal Server Error");
    });
});

// Serve the signup and login pages
app.get("/signup", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "signup.html"));
});

app.get("/login", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "login.html"));
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});