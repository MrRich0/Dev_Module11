INSERT INTO Client (NAME)
VALUES ('James Smith'),
       ('Emily Johnson'),
       ('Benjamin Davis'),
       ('Olivia Brown'),
       ('William Taylor'),
       ('Sophia Martinez'),
       ('Samuel Anderson'),
       ('Ava Wilson'),
       ('Alexander Thompson'),
       ('Mia Rodriguez');

INSERT INTO Planet (id, name) VALUES
        ('MARS', 'Mars'),
        ('VEN', 'Venus'),
        ('EAR', 'Earth'),
        ('JUP', 'Jupiter'),
        ('SAT', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
        (1, 'MARS', 'VEN'),
        (2, 'VEN', 'MARS'),
        (3, 'EAR', 'JUP'),
        (4, 'JUP', 'VEN'),
        (5, 'SAT', 'MARS'),
        (6, 'MARS', 'JUP'),
        (7, 'VEN', 'SAT'),
        (8, 'EAR', 'VEN'),
        (9, 'JUP', 'MARS'),
        (10, 'SAT', 'EAR');


