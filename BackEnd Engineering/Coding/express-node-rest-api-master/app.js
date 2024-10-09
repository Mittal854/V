const express = require("express");
const mongoose = require("mongoose");
const path = require("path");
const app = express();

const url =
  "mongodb+srv://bhuveshmittal854:bhuvesh@cluster0.i7hhkfd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

app.use(express.json());
app.use(express.urlencoded({ extended: true })); // To parse URL-encoded bodies (form data)
app.use(express.static("public"));

mongoose
  .connect(url, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => {
    console.log("Connected to database");
  })
  .catch((err) => {
    console.log("Some issue while connecting to the database", err);
  });

// Routes
const teacherRoute = require("./routes/teacher");
app.use("/teacher", teacherRoute);

// Serve the HTML form on the root route
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "public", "index.html"));
});

// Handle form submission
app.post("/sign_up", async (req, res) => {
  try {
    const teachers = require("./models/teacher");
    const data = new teachers({
      name: req.body.name,
      age: req.body.age,
      email: req.body.email,
      phno: req.body.phno,
      gender: req.body.gender,
      password: req.body.password,
    });

    await data.save();
    console.log("Record Inserted Successfully");

    // Redirect to a success page or send a success response
    res.redirect("/signup_successful.html"); // Make sure you have a success.html file in your public directory
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: "Failed to insert record" });
  }
});

app.listen(5000, () => {
  console.log("Server is running on port 5000");
});
