create type permtype as enum ('READ', 'READ_WRITE');
create table if not exists permissions
(
  permission_id serial primary key,
  permission_type permtype,
  role_id integer not null,
  constraint fk_role_id_roles foreign key (role_id) references roles(role_id) on delete cascade
);