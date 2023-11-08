CREATE TABLE ´Condition´ (
	id VARCHAR(255) PRIMARY KEY,
	´condition VARCHAR(64) NOT NULL,
	description VARCHAR(255),
	severity ENUM('MINOR', 'MODERATE', 'MAJOR', 'EXTREME'),
	dateDiagnosed DATE NOT NULL,
	dateRecovered DATE
);

CREATE TABLE Person (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	gender ENUM('MALE', 'FEMALE') NOT NULL,
	dob DATE NOT NULL,
	phoneNumber VARCHAR(64),
	email VARCHAR(128),
    role ENUM('PATIENT', 'DOCTOR', 'OTHER'),
    conditionId VARCHAR(255),
    doctorId VARCHAR(255),
    FOREIGN KEY (doctorId) REFERENCES Person(id),
    FOREIGN KEY (conditionId) REFERENCES ´Condition´(id)
);

CREATE TABLE Encounter(
id VARCHAR(255) PRIMARY KEY,
date DATE,
location VARCHAR(128),
patientId VARCHAR(255) NOT NULL,
doctorId VARCHAR(255) NOT NULL,
FOREIGN KEY(patientId) REFERENCES Person(id),
FOREIGN KEY(doctorId) REFERENCES Person(id)
);

CREATE TABLE Observation(
id VARCHAR(255) PRIMARY KEY,
observation VARCHAR(255) NOT NULL,
patientId VARCHAR(255) NOT NULL,
encounterId VARCHAR(255) NOT NULL,
FOREIGN KEY(patientId) REFERENCES Person(id),
FOREIGN KEY(encounterId) REFERENCES Encounter(id)
);

SELECT * FROM Person;