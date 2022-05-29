create table "Categories"
(
    id serial not null,
    category_name varchar not null
);
create unique index categories_id_uindex
    on "Categories" (id);
alter table "Categories"
    add constraint categories_pk
        primary key (id);
create table "Courses"
(
    id serial not null,
    course_name varchar not null,
    id_category int
);
create unique index courses_id_uindex
    on "Courses" (id);
alter table "Courses"
    add constraint courses_pk
        primary key (id);
