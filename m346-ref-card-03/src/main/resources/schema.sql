DROP TABLE IF EXISTS section;
CREATE TABLE section (
                           id int IDENTITY(1,1) PRIMARY KEY,
                           name varchar(255) NOT NULL
);

DROP TABLE IF EXISTS joke;
CREATE TABLE joke (
                        id int IDENTITY(1,1) PRIMARY KEY,
                        section_idfs int NOT NULL,
                        text varchar(255) NOT NULL,
                        rating int NOT NULL,
                        creation_date datetime NOT NULL
);




--
-- Indizes für die Tabelle `joke`
--
--ALTER TABLE `joke` ADD PRIMARY KEY (`id`);
--ALTER TABLE `section` ADD PRIMARY KEY (`id`);
--ALTER TABLE `joke` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--ALTER TABLE `section` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

