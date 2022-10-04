insert into role (id, name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

insert into user (id, email, enabled, password, username)
values (1,'admin@admin.com', 1, '123', 'admin');

insert into user_roles (user_id, roles_id)
VALUES (1,1),
       (1,2);

insert into score_increase (id, cha_increase, con_increase, dex_increase, int_increase, str_increase, wis_increase)
VALUES (1,0,0,0,0,0,0);

insert into race (id, description, name, walking_speed, score_increase_id)
VALUES (1, '-', 'Default', 0, 1),
       (2, '-', 'Human', 30, 1),
       (3, '-', 'Gnome', 25, 1);

insert into feats (id, description, name, score_increase_id)
VALUES (1, 'Default selection', '-', 1),
       (2, '-', 'Feat 1', 1),
       (3, '-', 'Feat 2', 1),
       (4, '-', 'Feat 3', 1),
       (5, '-', 'Feat 4', 1),
       (6, '-', 'Feat 5', 1),
       (7, '-', 'Feat 6', 1),
       (8, '-', 'Feat 7', 1),
       (9, '-', 'Feat 8', 1),;

insert into backgrounds (id, description, name)
VALUES (1, 'Default selection', '-'),
       (2, 'desc soldier', 'Soldier'),
       (2, 'desc noble', 'Noble'),
       (2, 'desc crossbow', 'Crossbow Expert');




