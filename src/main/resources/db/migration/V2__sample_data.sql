INSERT INTO categories (category_name)
VALUES ('Computer Science'), ('Maths'), ('Physics'), ('Psychology');

INSERT INTO courses (course_name, id_category, short_description, long_description, course_link)
VALUES
('Docker for beginners', (SELECT id from Categories WHERE category_name = 'Computer Science'), 'Welcome in our docker course for total beginners!', 'We will be covering all the important concepts related to the Docker Images, Docker Containers, Docker registry, Docker Swarm, and Docker Compose. The video also consists of the most important Docker Interview Questions from beginner to advanced level.', 'https://www.docker.com/'),
('Advance Geometry', (SELECT id from Categories WHERE category_name = 'Maths'), 'Advance concepts about complicated geometric problems', 'In this course, you will learn Geometry, Matrix, and Vectors. We are going to start from the basics and go deeper into all topics in Geometry related to Geometry.', 'https://www.youtube.com/watch?v=0bAyunUHa_Y&ab_channel=Matemaks'),
('History of Psychology', (SELECT id from Categories WHERE category_name = 'Psychology'), 'Everyone should know, how important psychology is in our lives! Check our course to get knowledge about psychology genesis!', 'The History of Psychology is a fundamental course for the student of psychology because it draws on research in many areas of psychology including psychotherapy, neuroscience, personality theory, cognition, psychopathology, human development, and social psychology.', 'https://pl.wikipedia.org/wiki/Psychologia');
