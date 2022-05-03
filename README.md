# eCourse

## Hi!
This web application will manage online courses.

## Table of contents
* [How to set up this app locally](#How-to-set-up-this-app-locally)
* [How to run an app](#How-to-run-an-app)
* [Instruction for users](#Instruction-for-users)
* [Documantation for programmers](#Documantation-for-programmers)

## How to set up this app locally

* [How to set up Database](#Database)
* [How to set up Backend](#Backend)
* [How to set up Frontend](#Frontend)

### Database
* Install PostgreSQL 14 
* Create database called "ecourse"
* Create tables using this SQL script:

```sql=
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

```

* Connect application to this database
* Test your connection

### Backend

### Frontend

In your project directory change directory into frontend project using (on Windows)
```bash=
cd .\frontend\ecourse\ 
```
after this, start frontend application using
```bash=
npm start
```
Application should start successfully on port 3000. Local address: http://localhost:3000
## How to run an app

### Backend

### Frontend

## Instruction for users

## Documantation for programmers


**Technologies:**
- Java 17
- Spring Boot
- Gradle
- PostgreSQL
