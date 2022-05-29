INSERT INTO Categories (category_name)
VALUES ('Computer Science'), ('Maths'), ('Physics'), ('Psychology');

INSERT INTO Courses (course_name, id_category)
VALUES
('Docker for beginners', (SELECT id from Categories WHERE category_name = 'Computer Science')),
('Advance Geometry', (SELECT id from Categories WHERE category_name = 'Maths')),
('History of Psychology', (SELECT id from Categories WHERE category_name = 'Psychology'));
