CREATE TABLE IF NOT EXISTS users
(
  user_id serial primary key,
  username varchar(50) not null,
  user_password varchar(75) not null
);