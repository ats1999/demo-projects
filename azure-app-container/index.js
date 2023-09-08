const express = require("express");
const axios = require("axios");
const app = express();
const PORT = 5000;

app.get("*", (req, res) => {
  axios
    .get("https://jsonplaceholder.typicode.com/photos")
    .then((apiRes) => res.send(apiRes.data))
    .catch((err) => {
      res.status(500).send(err);
    });
});
app.listen(PORT, () => console.log("Server is opened on: " + PORT));
