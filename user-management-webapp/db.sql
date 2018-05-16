CREATE TABLE IF NOT EXISTS users (
	id integer PRIMARY KEY AUTOINCREMENT,
	mail text UNIQUE NOT NULL,
	password text NOT NULL,
	username text,
	name text,
	bio text,
	avatar text,
	site text
);