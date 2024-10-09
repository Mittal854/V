const homeController = (req, res) => {
  res.render("index", { title: "home" });
};
export { homeController };
