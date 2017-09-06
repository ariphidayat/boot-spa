insert into users(id, email, password, enabled) values(1, 'arip@hidayat.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);
insert into users(id, email, password, enabled) values(2, 'alisiana@ulfah.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);

insert into authorities(id, user_id, authority) values(1, 1, 'DEVELOPER');
insert into authorities(id, user_id, authority) values(2, 1, 'ACTUATOR');
insert into authorities(id, user_id, authority) values(3, 2, 'ADMIN');

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) values('arip', '', 'aripsecret', 'read,write', 'password,authorization_code,refresh_token', '', '', 3600, 86400, '{}', '');