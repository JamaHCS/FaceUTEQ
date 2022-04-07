-- INSERT INTO role (id, name)
-- VALUES
-- (1, 'ROLE_USER'),
-- (2, 'ROLE_ADMIN');





create table if not exists inits(
    id int auto_increment primary key,
    created_at timestamp default current_timestamp,
    user varchar(100)
);

insert into inits (user) value('Jama');