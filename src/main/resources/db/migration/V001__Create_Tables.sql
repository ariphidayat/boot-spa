create table users(
  email varchar(50),
  password varchar(75) not null,
  enabled boolean not null,
  constraint pk_users primary key (email)
);

create table authorities (
  authority_id serial,
  email varchar(50) not null,
  authority varchar(50) not null,
  constraint pk_authorities primary key(authority_id),
  constraint fk_authorities_users foreign key(email) references users(email)
);
create unique index idx_authorities on authorities(email, authority);