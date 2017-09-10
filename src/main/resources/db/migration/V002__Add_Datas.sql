insert into users(id, email, password, enabled) values(1, 'arip@hidayat.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);
insert into users(id, email, password, enabled) values(2, 'alisiana@ulfah.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);

insert into roles(id, role) values(1, 'DEVELOPER');
insert into roles(id, role) values(2, 'USER');

insert into user_roles(user_id, role_id) values(1, 1);
insert into user_roles(user_id, role_id) values(2, 2);

insert into authorities(id, authority) values(1, 'ACTUATOR');
insert into authorities(id, authority) values(2, 'USER_SEARCH');
insert into authorities(id, authority) values(3, 'USER_VIEW');
insert into authorities(id, authority) values(4, 'USER_ADD');
insert into authorities(id, authority) values(5, 'USER_EDIT');
insert into authorities(id, authority) values(6, 'USER_DELETE');

insert into role_authorities(role_id, authority_id) values(1, 1);
insert into role_authorities(role_id, authority_id) values(1, 2);
insert into role_authorities(role_id, authority_id) values(1, 3);
insert into role_authorities(role_id, authority_id) values(1, 4);
insert into role_authorities(role_id, authority_id) values(1, 5);
insert into role_authorities(role_id, authority_id) values(1, 6);
insert into role_authorities(role_id, authority_id) values(2, 2);
insert into role_authorities(role_id, authority_id) values(2, 3);
insert into role_authorities(role_id, authority_id) values(2, 4);
insert into role_authorities(role_id, authority_id) values(2, 5);
insert into role_authorities(role_id, authority_id) values(2, 6);

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) values('arip', '', 'aripsecret', 'read,write', 'password,refresh_token', '', '', 3600, 86400, '{}', '');
insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) values('alisiana', '', 'aripsecret', 'openid', 'authorization_code,refresh_token', '', '', 3600, 86400, '{}', '');