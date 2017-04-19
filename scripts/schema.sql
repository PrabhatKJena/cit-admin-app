-- USER_GROUPS DDL
DROP TABLE user_groups CASCADE CONSTRAINTS;

CREATE TABLE user_groups (
  group_id NUMBER(8) PRIMARY KEY ,
  group_name VARCHAR2(8) NOT NULL ,
  group_desc VARCHAR2(80),
  status NUMBER(1) DEFAULT 1,
  create_ts DATE NOT NULL ,
  updated_ts DATE NOT NULL
);

ALTER TABLE user_groups ADD CONSTRAINT user_groups_grp_name_u UNIQUE (group_name);
ALTER TABLE user_groups ADD CONSTRAINT user_groups_status_chk CHECK( status in (0,1));

-- USERS table DDL
DROP TABLE USERS CASCADE CONSTRAINTS ;

CREATE TABLE users (
  user_id VARCHAR2(8) PRIMARY KEY,
  user_fname VARCHAR2(24) NOT NULL ,
  user_lname VARCHAR2(24),
  sex CHAR(1) NOT NULL ,
  email VARCHAR2(48) NOT NULL UNIQUE,
  phone NUMBER(10) UNIQUE ,
  is_active NUMBER(1) NOT NULL ,
  is_deleted NUMBER(1) NOT NULL ,
  create_ts DATE NOT NULL ,
  updated_ts DATE NOT NULL
);

ALTER TABLE USERS ADD CONSTRAINT users_sex_chk CHECK(sex IN ('M', 'F'));
ALTER TABLE USERS ADD CONSTRAINT users_is_active_chk CHECK( is_active in (0,1));

-- USER_LOGIN DDL
DROP TABLE user_login;

CREATE TABLE user_login(
  user_id VARCHAR2(8) NOT NULL ,
  login_name VARCHAR2(16) NOT NULL ,
  login_pwd VARCHAR2(16) NOT NULL ,
  group_id NUMBER(8),
  status NUMBER(1) NOT NULL,
  create_ts DATE NOT NULL ,
  updated_ts DATE NOT NULL
);

ALTER TABLE user_login ADD CONSTRAINT user_login_user_id_fk FOREIGN KEY(user_id) REFERENCES USERS(user_id);
ALTER TABLE user_login ADD CONSTRAINT user_login_login_name_u UNIQUE(login_name);
ALTER TABLE user_login ADD CONSTRAINT user_login_id_name_pk PRIMARY KEY (user_id, login_name);
ALTER TABLE user_login ADD CONSTRAINT user_login_status_chk CHECK( status in (0,1));
ALTER TABLE user_login ADD CONSTRAINT user_login_group_id_fk FOREIGN KEY(group_id) REFERENCES user_groups(group_id);


