const express = require("express");
const jwt = require("jsonwebtoken");

const app = express();
const secretKey = "bbbbbbbeeeeeeeeemmmmm";

app.get("/", (req, res) => {
  res.json({
    message: "Welcome to the API",
  });
});

app.post("/login", (req, res) => {
  const user = {
    id: 1,
    name: "bee",
    email: "bee@gmail.com",
  };
  jwt.sign({ user }, secretKey, { expiresIn: "300s" }, (err, token) => {
    res.json({
      token,
    });
  });
});

app.post("/profile", verifyT, (req, res) => {
  jwt.verify(req.token, secretKey, (err, authData) => {
    if (err) {
      res.send({ result: "invalid token" });
    } else {
      res.json({
        message: "profile sent successfully",
        authData,
      });
    }
  });
});

function verifyT(req, res, next) {
  const getHeader = req.headers["authorization"];
  if (typeof getHeader !== "undefined") {
    const bearer = getHeader.split(" ");
    const token = bearer[1];
    req.token = token;
    next();
  } else {
    res.send({ result: "token not valid" });
  }
}

app.listen(3000, () => console.log("app running on port 3000"));
