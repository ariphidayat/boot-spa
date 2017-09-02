create table users(
  id serial,
  email varchar(50),
  password varchar(75) not null,
  enabled boolean not null,
  constraint pk_users primary key (id),
  constraint uk_users_email unique (email)
);

create table authorities (
  id serial,
  user_id bigint not null,
  authority varchar(50) not null,
  constraint pk_authorities primary key(id),
  constraint fk_authorities_users foreign key(user_id)
    references users(id) match simple
    on update cascade on delete cascade
);
create unique index idx_authorities on authorities(user_id, authority);