// const express = require("express");
// const app = express();
// const myLogger = function (req, res, next) {
//   console.log("LOGGED");
//   next();
// };
// app.use(myLogger);
// app.get("/", (req, res) => {
//   res.send("Hello World!");
// });
// app.listen(3000);

// const express = require("express");
// const app = express();
// const requestTime = function (req, res, next) {
//   req.requestTime = Date();
//   next();
// };
// app.use(requestTime);
// app.get("/", (req, res) => {
//   let responseText = "Hello World!<br>";
//   responseText += `<small>Requested at: ${req.requestTime}</small>`;
//   res.send(responseText);
// });
// app.listen(3000);

// const express = require("express");
// const app = express();

// app.use(function (req, res, next) {
//   console.log("new req rec" + Date());

// });

// app.get("/users", (req, res, next) => {
//   res.send("USER");
// });
// app.listen(3000);

// const express = require("express");
// const app = express();

// app.use(function (req, res, next) {
//   console.log("new req rec" + Date());
//   next();
// });

// app.get("/users", (req, res, next) => {
//   res.send("USER");
// });
// app.listen(3000);

// const express = require('express')
// const app = express()

// app.use(function(req,res,next){
//     console.log("new req rec"+Date());
//     next();
// });
// app.get('/users', (req, res, next) => {
//     res.send('USER');
//     next();
//   })
// app.get('/users', (req, res, next) => {
//     res.send('end user')
//   })
// app.listen(3000)

// const express = require("express");
// const app = express();

// app.use(function (req, res, next) {
//   console.log("new req rec" + Date());
//   next();
// });
// app.get("/users", (req, res, next) => {
//   res.send("USER");
//   next();
// });
// app.get("/users", (req, res, next) => {
//   res.send("end user");
// });
// app.listen(3000);

// const express = require("express");
// const app = express();
// const router = express.Router();

// // a middleware function with no mount path. This code is executed for every request to the router
// router.use((req, res, next) => {
//   console.log("Time:", Date.now());
//   next();
// });

// // a middleware sub-stack shows request info for any type of HTTP request to the /user/:id path
// router.use(
//   "/user/:id",
//   (req, res, next) => {
//     console.log("Request URL:", req.originalUrl);
//     next();
//   },
//   (req, res, next) => {
//     console.log("Request Type:", req.method);
//     next();
//   }
// );

// // mount the router on the app
// app.use("/", router);

// app.listen(3000);


const express = require("express");
const app = express();
const router = express.Router();
router.use((req, res, next) => {
  if (!req.headers["x-auth"]) return next("router");
  next();
});

router.get("/user/:id", (req, res) => {
  res.send("hello, user!");
});

// use the router and 401 anything falling through
app.use("/admin", router, (req, res) => {
  res.sendStatus(401);
});
app.listen(3000);
