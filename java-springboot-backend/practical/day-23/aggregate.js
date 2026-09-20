db.posts.aggregate([{$unwind:'$tags'},{$group:{_id:'$tags',count:{$sum:1}}},{$sort:{count:-1}}]);
