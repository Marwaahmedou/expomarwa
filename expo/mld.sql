CREATE TABLE Bibliotheque(
   Idbib INT,
   Nom VARCHAR(50),
   Emplacement VARCHAR(52),
   PRIMARY KEY(Idbib)
);

CREATE TABLE Auteur(
   IdAut INT,
   Prenom VARCHAR(50),
   Nom VARCHAR(50),
   Adresse VARCHAR(50),
   Region VARCHAR(50),
   PRIMARY KEY(IdAut)
);

CREATE TABLE Livre(
   ISBN INT,
   Titre VARCHAR(50),
   IdAut INT NOT NULL,
   PRIMARY KEY(ISBN),
   FOREIGN KEY(IdAut) REFERENCES Auteur(IdAut)
);

CREATE TABLE Telephone(
   Numero INT,
   Type VARCHAR(50),
   IdAut INT NOT NULL,
   PRIMARY KEY(Numero),
   UNIQUE(IdAut),
   FOREIGN KEY(IdAut) REFERENCES Auteur(IdAut)
);

CREATE TABLE Associer(
   Idbib INT,
   IdAut INT,
   PRIMARY KEY(Idbib, IdAut),
   FOREIGN KEY(Idbib) REFERENCES Bibliotheque(Idbib),
   FOREIGN KEY(IdAut) REFERENCES Auteur(IdAut)
);
