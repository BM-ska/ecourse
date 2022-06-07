INSERT INTO Categories (category_name)
VALUES ('Computer Science'), ('Maths'), ('Physics'), ('Psychology'),
       ('Computer Science1'), ('Maths1'), ('Physics1'), ('Psychology1'),
       ('Computer Science2'), ('Maths2'), ('Physics2'), ('Psychology2'),
       ('Computer Science3');

INSERT INTO Courses (course_name, id_category)
VALUES
('Docker for beginners', (SELECT id from Categories WHERE category_name = 'Computer Science')),
('Advance Geometry', (SELECT id from Categories WHERE category_name = 'Maths')),
('History of Psychology', (SELECT id from Categories WHERE category_name = 'Psychology')),
('Prime numbers', (SELECT id from Categories WHERE category_name = 'Maths'));
