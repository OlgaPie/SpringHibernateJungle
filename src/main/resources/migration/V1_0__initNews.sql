CREATE TABLE "public"."news"  (
	"id"     	int NOT NULL,
	"title"  	varchar(255) NOT NULL,
	"content"	text NOT NULL,
	"date"   	date NOT NULL
	);


INSERT INTO "public"."news"("id", "title", "content", "date")
VALUES(3, 'новость 3', 'контент 3', '2016-08-01');

INSERT INTO "public"."news"("id", "title", "content", "date")
VALUES(2, 'новость 2', 'контент 2', '2016-07-15');

INSERT INTO "public"."news"("id", "title", "content", "date")
VALUES(1, 'новость 1', 'контент 1', '2016-07-01');