create table categories
(
    id serial PRIMARY KEY,
    category_name varchar not null
);
create unique index categories_id_uindex
    on categories (id);

create table courses
(
    id serial PRIMARY KEY,
    course_name varchar not null,
    id_category int not null,
    short_description varchar not null,
    long_description varchar,
    course_link varchar,
    CONSTRAINT fk_category FOREIGN KEY(id_category) REFERENCES categories (id)
);
create unique index courses_id_uindex
    on courses (id);
