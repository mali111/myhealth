
  DROP TABLE IF EXISTS BASIC_USER_INFO;

CREATE TABLE BASIC_USER_INFO (
  id INT AUTO_INCREMENT  PRIMARY KEY,firstName VARCHAR(250) NOT NULL,lastName VARCHAR(250) NOT NULL, dob VARCHAR(250) NOT NULL,
   age VARCHAR(250) NOT NULL, gender VARCHAR(250) NOT NULL, weight VARCHAR(250) NOT NULL,
  OrganDonor BOOLEAN, bloodGroup VARCHAR(250) NOT NULL, pregnant BOOLEAN, additionalInfo VARCHAR(250) NOT NULL
);

INSERT INTO BASIC_USER_INFO VALUES
  (111,'Daniel', 'Dack', '20.02.1990','34','male','65kg',TRUE,'0+ve',FALSE,'i am awesome'),
  (112,'Ali', 'Umar', '20.02.1985','25','male','55kg',TRUE,'A-ve',FALSE,'I have nothing to say'),
  (113,'Nadja', 'Brandel', '20.02.1975','55','female','55kg',TRUE,'A-ve',TRUE,'How are you'),
  (114,'Rania', 'Khawar', '20.02.2005','15','female','15kg',FALSE,'B-ve',FALSE,'Say something');
