insert into users(email, password, enabled) values('arip@hidayat', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);
insert into users(email, password, enabled) values('alisiana@ulfah.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);

insert into authorities(authority_id, email, authority) values(1, 'arip@hidayat', 'DEVELOPER');
insert into authorities(authority_id, email, authority) values(2, 'alisiana@ulfah.com', 'ADMIN');