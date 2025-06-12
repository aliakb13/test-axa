create table if not exists roles
(
  role_id serial primary key,
  role_name varchar(50) not null,
  user_id integer not null,
  constraint fk_user_id_users foreign key (user_id) references users(user_id) on delete cascade
);