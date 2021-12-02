CREATE TABLE IF NOT EXISTS users (
    user_id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
    user_name VARCHAR(100) NOT NULL
);
insert into users (user_name) values ('Hercules Finlaison');
insert into users (user_name) values ('Falkner Hirtz');
insert into users (user_name) values ('Britte Parton');
insert into users (user_name) values ('Raviv Hylton');
insert into users (user_name) values ('Gonzalo Ferenczi');
insert into users (user_name) values ('Shirline Grewcock');
insert into users (user_name) values ('Tod Capps');
insert into users (user_name) values ('Alia McCowen');
insert into users (user_name) values ('Temp Udy');
insert into users (user_name) values ('Sammy Hufton');
