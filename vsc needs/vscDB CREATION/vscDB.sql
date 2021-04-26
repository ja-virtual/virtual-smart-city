--    Inés tables

CREATE TABLE Municipality(
   id_Municipality INT,
   region VARCHAR(50),
   rental_permises_nbr VARCHAR(50),
   town VARCHAR(50),
   PRIMARY KEY(id_Municipality)
);

CREATE TABLE Authorities(
   id_Authorities INT,
   region VARCHAR(50),
	id_Municipality INT,
   PRIMARY KEY(id_Authorities),
FOREIGN KEY (id_Municipality) REFERENCES Municipality(id_Municipality)
 );
-- Hajar tables

CREATE TABLE GeneralServices(
   id_generalServices INT,
   idCompany INT NOT NULL,
   PRIMARY KEY(id_generalServices)
);

CREATE TABLE Positions(
   id_position INT,
   longitude INT NOT NULL,
   latitude INT NOT NULL,
   id_map INT NOT NULL,
   PRIMARY KEY(id_position)
);

CREATE TABLE Building(
   id_building INT,
   PRIMARY KEY(id_building)
);

-- amal tables

CREATE TABLE Workspace(
   id_workspace INT,
   individual__office BOOLEAN,
   meeting_room BOOLEAN,
   openspace_ BOOLEAN,
   area INT,
   high_floor BOOLEAN,
   price INT,
   id_building INT,
   floor_number INT,
   employee_number INT,
   is_avalaible BOOLEAN,
   rent_by VARCHAR(50),
   PRIMARY KEY(id_workspace),
   FOREIGN KEY(id_building) REFERENCES Building(id_building)
);

CREATE TABLE Equipment(
   id_equipment INT,
   type_equipment VARCHAR(50),
   is_available BOOLEAN,
   is_working BOOLEAN,
   installation_date DATE,
   id_generalServices INT,
   id_position INT,
   PRIMARY KEY(id_equipment),
   UNIQUE(id_position),
   FOREIGN KEY(id_generalServices) REFERENCES GeneralServices(id_generalServices),
   FOREIGN KEY(id_position) REFERENCES Positions(id_position)
);

CREATE TABLE Sensor(
   id_Sensor INT,
   type_sensor VARCHAR(50),
   is_available BOOLEAN,
   is_working BOOLEAN,
   installation_date DATE,
   id_generalServices INT,
   id_position INT,
   PRIMARY KEY(id_Sensor),
   UNIQUE(id_position),
   FOREIGN KEY(id_generalServices) REFERENCES GeneralServices(id_generalServices),
   FOREIGN KEY(id_position) REFERENCES Positions(id_position)
);

CREATE TABLE Map(
   id_map INT,
   floor_number INT,
   id_workspace INT ,
   id_building INT,
   PRIMARY KEY(id_map),
   FOREIGN KEY(id_workspace) REFERENCES WorkSpace(id_workspace),
   FOREIGN KEY(id_building) REFERENCES Building(id_building)
);

-- Coumba's tables

CREATE TABLE Windows(
   id_windows INT,
   blind VARCHAR(50),
   opacity VARCHAR(50),
   id_equipment INT NOT NULL,
   PRIMARY KEY(id_windows),
   FOREIGN KEY(id_equipment) REFERENCES Equipment(id_equipment)
);

CREATE TABLE Temperature(
   id_temperature INT,
   degree INT,
   id_windows INT,
   PRIMARY KEY(id_temperature),
   FOREIGN KEY(id_windows) REFERENCES Windows(id_windows)
);

CREATE TABLE Lighting(
   id_light INT,
   level VARCHAR(50),
   id_windows INT,
   PRIMARY KEY(id_light),
   FOREIGN KEY(id_windows) REFERENCES Windows(id_windows)
);

-- Mohand tables
CREATE TABLE Empowerment(
   id_empowerment INT,
   type_empowerment VARCHAR(50) NOT NULL,
   id_equipement INT NOT NULL,
   PRIMARY KEY(id_empowerment),
   FOREIGN KEY(id_equipement) REFERENCES Equipment(id_equipment)
);

CREATE TABLE Person(
   id_person INT,
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   age INT NOT NULL,
   PRIMARY KEY(id_person)
);

CREATE TABLE Employee(
   id_matricule INT,
   fonction VARCHAR(50) NOT NULL,
   manager VARCHAR(50) NOT NULL,
   id_person INT NOT NULL,
   PRIMARY KEY(id_matricule),
   FOREIGN KEY(id_person) REFERENCES Person(id_person)

);

CREATE TABLE AccessLevel(
   id_accessLevel INT,
   id_equipement INT NOT NULL,
   id_workspace INT NOT NULL,
   PRIMARY KEY(id_accessLevel),
   FOREIGN KEY(id_workspace) REFERENCES WorkSpace(id_workspace),
   FOREIGN KEY(id_equipement) REFERENCES Equipment(id_equipment)
);

CREATE TABLE TokenGenerator(
  id_token INT,
  token VARCHAR(50),
  id_accessLevel INT,
  PRIMARY KEY(id_token),
  FOREIGN KEY(id_accessLevel) REFERENCES AccessLevel(id_accessLevel)
);


CREATE TABLE AccessCard(
   id_accessCard VARCHAR(50) NOT NULL UNIQUE,
   type_card VARCHAR(50) NOT NULL,
   statut_card VARCHAR(50) NOT NULL,
   id_matricule INT NOT NULL,
   id_generalServices INT NOT NULL,
   id_empowerment INT NOT NULL,
   id_token INT NOT NULL,
   id_accessLevel INT NOT NULL,
   FOREIGN KEY(id_matricule) REFERENCES Employee(id_matricule),
   FOREIGN KEY(id_generalServices) REFERENCES GeneralServices(id_generalServices),
   FOREIGN KEY(id_empowerment) REFERENCES Empowerment(id_empowerment),
   FOREIGN KEY(id_token) REFERENCES TokenGenerator(id_token),
   FOREIGN KEY(id_accessLevel) REFERENCES AccessLevel(id_accessLevel)
);