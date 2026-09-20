db.posts.insertOne({
  title: "Hello Mongo",
  tags: ["java", "mongo"],
  author: { name: "Ada" },
  comments: [{ body: "Nice", at: new Date() }]
});
db.posts.find({ tags: "mongo" }).pretty();
