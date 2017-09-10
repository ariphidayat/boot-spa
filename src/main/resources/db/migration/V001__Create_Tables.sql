-- Spring Security Schema
create table users(
  id serial,
  email varchar(50),
  password varchar(75) not null,
  enabled boolean not null,
  constraint pk_users primary key (id),
  constraint uk_users_email unique (email)
);

create table roles (
  id serial,
  role varchar(50) not null,
  constraint pk_roles primary key(id),
  constraint uk_roles_role_name unique(role)
);

create table user_roles (
  user_id bigint not null,
  role_id bigint not null,
  constraint fk_user_roles_users foreign key(user_id)
    references users(id) match simple
    on update restrict on delete restrict,
  constraint fk_user_roles_roles foreign key(role_id)
    references users(id) match simple
    on update restrict on delete restrict
);
create unique index idx_user_roles on user_roles(user_id, role_id);

create table authorities (
  id serial,
  authority varchar(50) not null,
  constraint pk_authorities primary key(id),
  constraint uk_authorities_authority unique(authority)
);

create table role_authorities (
  role_id bigint not null,
  authority_id bigint not null,
  constraint fk_role_authorities_roles foreign key(role_id)
    references roles(id) match simple
    on update restrict on delete restrict,
  constraint fk_role_authorities_authorities foreign key(authority_id)
    references authorities(id) match simple
    on update restrict on delete restrict
);
create unique index idx_role_authorities on role_authorities(role_id, authority_id);
-- END

-- Spring Security OAuth2 Schema
create table oauth_client_details (
  client_id varchar(256),
  resource_ids varchar(256),
  client_secret varchar(256),
  scope varchar(256),
  authorized_grant_types varchar(256),
  web_server_redirect_uri varchar(256),
  authorities varchar(256),
  access_token_validity integer,
  refresh_token_validity integer,
  additional_information varchar(4096),
  autoapprove varchar(256),
  constraint pk_oauth_client_details primary key(client_id)
);

create table oauth_client_token (
  token_id varchar(256),
  token bytea,
  authentication_id varchar(256),
  user_name varchar(256),
  client_id varchar(256)
);

create table oauth_access_token (
  token_id varchar(256),
  token bytea,
  authentication_id varchar(256),
  user_name varchar(256),
  client_id varchar(256),
  authentication bytea,
  refresh_token varchar(256)
);

create table oauth_refresh_token (
  token_id varchar(256),
  token bytea,
  authentication bytea
);

create table oauth_code (
  code varchar(256),
  authentication bytea
);

create table oauth_approvals (
  userId varchar(256),
  clientId varchar(256),
  scope varchar(256),
  status varchar(10),
  expiresAt timestamp,
  lastModifiedAt timestamp
);
-- END

-- Spring Session Schema
-- Actual Schema Location: org\springframework\session\jdbc\schema-postgresql.sql
create table spring_session (
  session_id char(36) not null,
  creation_time bigint not null,
  last_access_time bigint not null,
  max_inactive_interval int not null,
  principal_name varchar(100),
  constraint pk_spring_session primary key (session_id)
);
create index idx_spring_session on spring_session (last_access_time);

create table spring_session_attributes (
  session_id char(36) not null,
  attribute_name varchar(200) not null,
  attribute_bytes bytea not null,
  constraint pk_spring_session_attributes primary key (session_id, attribute_name),
  constraint fk_spring_session_attributes foreign key (session_id)
    references spring_session(session_id)
    on delete cascade
);
create index idx_spring_session_attributes on spring_session_attributes (session_id);
-- END