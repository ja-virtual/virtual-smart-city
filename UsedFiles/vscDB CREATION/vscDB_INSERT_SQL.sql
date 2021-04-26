-- General Services INSERT

insert into GeneralServices (id_generalservices, idcompany) values (3, 1);
insert into GeneralServices (id_generalservices, idcompany) values (2, 2);
insert into GeneralServices (id_generalservices, idcompany) values (4, 3);
insert into GeneralServices (id_generalservices, idcompany) values (5, 4);
insert into GeneralServices (id_generalservices, idcompany) values (1, 5);

-- Person INSERT

insert into Person (id_person, firstname, lastname, age) values (1, 'Isidore', 'Davidsohn', 29);
insert into Person (id_person, firstname, lastname, age) values (4, 'Ketty', 'Bill', 53);
insert into Person (id_person, firstname, lastname, age) values (2, 'Brittni', 'Lea', 32);
insert into Person (id_person, firstname, lastname, age) values (3, 'Emmy', 'Lording', 39);
insert into Person (id_person, firstname, lastname, age) values (1, 'Merilee', 'L'' Estrange', 45);

-- Employee INSERT

insert into Employee (id_matricule, fonction, manager, id_person) values (2, 'Apprentice', 'Amy Heyns', 4);
insert into Employee (id_matricule, fonction, manager, id_person) values (2, 'Manager', 'Lee Growden', 3);
insert into Employee (id_matricule, fonction, manager, id_person) values (5, 'System Architect', 'Jeralee Hebbes', 3);
insert into Employee (id_matricule, fonction, manager, id_person) values (3, 'System Architect', 'Laurette Wybron', 3);
insert into Employee (id_matricule, fonction, manager, id_person) values (1, 'Apprentice', 'Rosabella Roddan', 4);


-- Empowerment INSERT

insert into Empowerment (id_empowerment, type_empowerment, id_equipement) values (5, 'IT', 3);
insert into Empowerment (id_empowerment, type_empowerment, id_equipement) values (1, 'IT', 2);
insert into Empowerment (id_empowerment, type_empowerment, id_equipement) values (4, 'IT', 1);
insert into Empowerment (id_empowerment, type_empowerment, id_equipement) values (2, 'IT', 4);
insert into Empowerment (id_empowerment, type_empowerment, id_equipement) values (3, 'Security', 4);

-- Access Level INSERT

insert into AccessLevel (id_accesslevel, id_equipement, id_workspace) values (3, 1, 1);
insert into AccessLevel (id_accesslevel, id_equipement, id_workspace) values (1, 3, 4);
insert into AccessLevel (id_accesslevel, id_equipement, id_workspace) values (3, 5, 4);
insert into AccessLevel (id_accesslevel, id_equipement, id_workspace) values (3, 4, 1);
insert into AccessLevel (id_accesslevel, id_equipement, id_workspace) values (2, 4, 1);

-- Token Generator INSERT

insert into TokenGenerator (id_token, token, id_accesslevel) values (4, 'frojfoejzf4484ezaerth', 3);
insert into TokenGenerator (id_token, token, id_accesslevel) values (5, 'frojfoejzf4484ezae86d', 2);
insert into TokenGenerator (id_token, token, id_accesslevel) values (3, 'frojfoejzf4484ezaezef', 2);
insert into TokenGenerator (id_token, token, id_accesslevel) values (4, 'frojfoejzf4484ezae862', 2);
insert into TokenGenerator (id_token, token, id_accesslevel) values (5, 'frojfoejzf4484ezaeze5', 1);

-- ACCESS CARD INSERT

insert into AccessCard (id_accesscard, type_card, statut_card, id_matricule, id_generalservices, id_empowerment, id_token, id_accesslevel) values (1, 'Visitor', 'Warning', 1, 2, 1, 5, 1);
insert into AccessCard (id_accesscard, type_card, statut_card, id_matricule, id_generalservices, id_empowerment, id_token, id_accesslevel) values (2, 'Visitor', 'Warning', 1, 5, 5, 3, 2);
insert into AccessCard (id_accesscard, type_card, statut_card, id_matricule, id_generalservices, id_empowerment, id_token, id_accesslevel) values (3, 'Visitor', 'KO', 5, 2, 2, 5, 3);
insert into AccessCard (id_accesscard, type_card, statut_card, id_matricule, id_generalservices, id_empowerment, id_token, id_accesslevel) values (4, 'Security agent', 'OK', 1, 2, 5, 1, 1);
insert into AccessCard (id_accesscard, type_card, statut_card, id_matricule, id_generalservices, id_empowerment, id_token, id_accesslevel) values (5, 'Security agent', 'OK', 5, 3, 3, 5, 3);








