-- DROP all tables if exists - START
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE user_groups CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE users CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE user_login CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE user_role CASCADE CONSTRAINTS';
  EXCEPTION
  WHEN OTHERS THEN
  IF SQLCODE != -942 THEN
    RAISE;
  END IF;
END;
-- DROP all tables if exists - END

-- USER_GROUPS DDL
CREATE TABLE user_groups (
  group_id NUMBER(3) PRIMARY KEY ,
  group_name VARCHAR2(16) NOT NULL ,
  group_value NUMBER(2) NOT NULL ,
  group_desc VARCHAR2(80),
  status NUMBER(1) DEFAULT 1,
  created_ts DATE NOT NULL ,
  updated_ts DATE NOT NULL
);

ALTER TABLE user_groups ADD CONSTRAINT user_groups_grp_name_u UNIQUE (group_name);
ALTER TABLE user_groups ADD CONSTRAINT user_groups_grp_value_u UNIQUE (group_value);
ALTER TABLE user_groups ADD CONSTRAINT user_groups_status_chk CHECK( status in (0,1));

-- USERS table DDL
CREATE TABLE users (
  user_id VARCHAR2(8) PRIMARY KEY,
  user_fname VARCHAR2(24) NOT NULL ,
  user_lname VARCHAR2(24),
  sex CHAR(1) NOT NULL ,
  email VARCHAR2(48) NOT NULL UNIQUE,
  phone NUMBER(10) UNIQUE ,
  is_active NUMBER(1) NOT NULL ,
  create_ts DATE NOT NULL ,
  updated_ts DATE NOT NULL
);

ALTER TABLE USERS ADD CONSTRAINT users_sex_chk CHECK(sex IN ('M', 'F'));
ALTER TABLE USERS ADD CONSTRAINT users_is_active_chk CHECK( is_active in (0,1));

-- USER_LOGIN DDL
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

-- DDL for USER_ROLE table
CREATE TABLE user_role (
  user_id    VARCHAR2(8) NOT NULL,
  user_role  NUMBER(3)   NOT NULL,
  is_active  NUMBER(1),
  create_ts  DATE        NOT NULL,
  updated_ts DATE        NOT NULL
);

ALTER TABLE user_role ADD CONSTRAINT user_role_user_id_pk PRIMARY KEY (user_id, user_role);
ALTER TABLE user_role ADD CONSTRAINT user_role_user_id_fk FOREIGN KEY (user_id) REFERENCES USERS (user_id);
ALTER TABLE user_role ADD CONSTRAINT user_role_user_role_fk FOREIGN KEY (user_role) REFERENCES USER_GROUPS (GROUP_ID);
ALTER TABLE user_role ADD CONSTRAINT users_role_is_active_chk CHECK( is_active in (0,1));

