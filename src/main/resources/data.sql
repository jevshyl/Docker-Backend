--USERS
-- you can user gen_random_uuid () to generate random IDs, use this only to generate testdata
insert into users (id, email,first_name,last_name, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James','Bond', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'), -- Password: 1234 | Roles: Admin & Default
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler','Durden', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6') -- Password: 1234 |  Roles: User & Default
       --todo: user with just default role
 ON CONFLICT DO NOTHING;


--ROLES
INSERT INTO role(id, name)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
       ('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
       ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--todo: make more types of authorities
--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
       ('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
       ('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DEACTIVATE')
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'),
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'),
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02')
 ON CONFLICT DO NOTHING;

--todo: assign the new authorities
--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', '2ebf301e-6c61-4076-98e3-2a38b31daf86'), -- role: default
       ('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'), -- role: admin
       ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '21c942db-a275-43f8-bdd6-d048c21bf5ab')  -- role: user
 ON CONFLICT DO NOTHING;


--LIST ELEMENTS
INSERT INTO list_element(id, title, text, importance, creation_date, user_id)
VALUES ('9a6f47b4-70b7-42f8-874b-6eb9e5d1d32f', 'Talk with Bobby', 'I want to talk with bobby about the money increas about the new project.', 'HIGH', '2025-09-24', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de'),
       ('0f3d6c64-63aa-4f72-8c76-04bb7dc8a9d9', 'Look at grades with Gianluca', 'The grades from tbz were just send, and i wanna explain to Gianluca why english only has a 4.', 'MEDIUM', '2025-10-26', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de'),
       ('8a34c2b9-0e59-46eb-a409-2c8d3f4fd527', 'Clean room', 'Vacuum the floor, clean the windows & empty the trash.', 'LOW', '2025-09-22', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de'),
       ('45f1c7b1-30b6-4a2d-98f6-8fa3fbc15a5c', 'Learn sewing', 'A big dream of mine, wich i now wanna pursue in the holidays.', 'LOW', '2025-09-22', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de'),
       ('f0c3b7a2-ec58-4b48-8e7c-415f9f88951a', 'Cook 5 star dinner', 'For my Family and friends.', 'MEDIUM', '2025-09-20', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de'),
       ('b9c8d57a-7a2e-4f9d-87e3-2cbb84fa5de4', 'Do math homework', 'Pages 12 - 14.', 'HIGH', '2025-08-02', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de'),
       ('12f4c8d3-9e5b-41a4-b84d-12db48c28f5e', 'Go jogging', 'Get that body tea.', 'MEDIUM', '2025-09-24', '0d8fa44c-54fd-4cd0-ace9-2a7da57992de')
ON CONFLICT DO NOTHING;

--c3a1d4d9-7e08-4e89-8f94-5a63f67f2a9a
--6b8e3a27-7cfa-4c5c-87f0-46e8a5d907ef
--4f91c2b0-ff93-49d6-aef0-81ab47bb3fa2
--37e2df45-2f79-41aa-b0c5-d3a87a4cf81a
--93dfbfa8-35f7-4419-a1a0-19cbf48bcb4d
--aa4c6e3f-b54a-4937-83a1-1f6bb7db3e6e