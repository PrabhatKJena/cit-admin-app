BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE consultants CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE consultants_activity CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE skills CASCADE CONSTRAINTS';

  --EXECUTE IMMEDIATE 'DROP SEQUENCE user_login_seq';
  EXCEPTION
  WHEN OTHERS THEN
  IF SQLCODE !=-955 AND SQLCODE != -942
  THEN
    RAISE;
  END IF;
END;

-- DDL form CONSULTANTS table
CREATE TABLE consultants(
  id VARCHAR2(8) PRIMARY KEY ,
  fname VARCHAR2(24) NOT NULL ,
  lname VARCHAR2(24),
  sex char(1),
  date_of_onboard DATE NOT NULL ,
  phone NUMBER(10) NOT NULL ,
  phone_country_code NUMBER(3),
  email VARCHAR2(48) NOT NULL ,
  is_active NUMBER(1) DEFAULT 0,
  skill_set VARCHAR2(256), -- skill ids separated by comma
  createed_ts DATE,
  upated_ts DATE
);

ALTER TABLE consultants ADD CONSTRAINT consultants_sex_chk CHECK(sex IN ('M', 'F'));
ALTER TABLE consultants ADD CONSTRAINT consultants_is_active_chk CHECK( is_active in (0,1));

CREATE OR REPLACE TRIGGER consultants_generator
BEFORE INSERT ON consultants
FOR EACH ROW
  DECLARE
    last_id consultants.id%TYPE;
    last_id_n NUMBER;
    rec_count NUMBER;
  BEGIN
    SELECT count(1) INTO rec_count FROM consultants;
    IF rec_count = 0
    THEN
      last_id_n:=0;
    ELSE
      select TO_NUMBER(substr(ID,2))INTO last_id_n from consultants where CREATED_TS = (SELECT max(CREATED_TS) from consultants);
    END IF;
    select ('C'||lpad(last_id_n+1,7,'0')) INTO last_id from dual;
    SELECT last_id
    INTO   :new.ID
    FROM   dual;
  END;
/

-- DDL for consultants_activity table
CREATE TABLE consultants_activity(
  id NUMBER PRIMARY KEY ,
  consultant_id VARCHAR2(8) NOT NULL ,
  active_from DATE NOT NULL ,
  active_to DATE,
  skill_set VARCHAR2(256)
);
ALTER TABLE consultants_activity ADD CONSTRAINT consultants_consult_id_fk FOREIGN KEY (consultant_id) REFERENCES consultants(id);

-- DDL for SKILLS table
CREATE TABLE skills(
  id NUMBER PRIMARY KEY ,
  name VARCHAR2(64) NOT NULL UNIQUE ,
  description VARCHAR2(256)
);