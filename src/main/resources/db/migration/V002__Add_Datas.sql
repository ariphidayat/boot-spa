insert into users(id, email, password, enabled) values(1, 'arip@hidayat.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);
insert into users(id, email, password, enabled) values(2, 'alisiana@ulfah.com', '$2a$10$OvHLBKNsOrlmzuLuGxBvP.yxpFFmG84niVotqwwZahv7vjKp5N672', true);

insert into authorities(id, user_id, authority) values(1, 1, 'DEVELOPER');
insert into authorities(id, user_id, authority) values(2, 2, 'ADMIN');