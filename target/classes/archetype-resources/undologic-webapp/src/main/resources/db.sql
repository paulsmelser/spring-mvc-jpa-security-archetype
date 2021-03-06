CREATE TABLE IF NOT EXISTS Control (

  Id BIGINT,
  line  VARCHAR(100)
);

CREATE TABLE  IF NOT EXISTS users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE  IF NOT EXISTS user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

INSERT INTO users(username,password,enabled)
VALUES ('joe','123456', TRUE);
INSERT INTO users(username,password,enabled)
VALUES ('john','123456', TRUE);

INSERT INTO user_roles (username, ROLE)
VALUES ('joe', 'ROLE_USER');
INSERT INTO user_roles (username, ROLE)
VALUES ('joe', 'ROLE_ADMIN');
INSERT INTO user_roles (username, ROLE)
VALUES ('john', 'ROLE_USER');

