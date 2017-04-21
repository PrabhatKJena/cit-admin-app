-- Triggers for USER_GROUP table
CREATE OR REPLACE TRIGGER user_group_generator
BEFORE INSERT ON user_groups
FOR EACH ROW
  DECLARE
    last_id user_groups.group_id%TYPE;
  BEGIN
    select NVL(max(group_id)+1,1) INTO last_id from USER_GROUPS;
    SELECT last_id
    INTO   :new.group_id
    FROM   dual;
  END;
/

CREATE OR REPLACE TRIGGER USER_GROUP_UPDATE_TRIGGER
BEFORE UPDATE ON user_groups
FOR EACH ROW
  BEGIN
    SELECT current_timestamp
    INTO   :new.updated_ts
    FROM   dual;
  END;
/

CREATE OR REPLACE TRIGGER USER_GROUP_INSERT_TRIGGER
BEFORE INSERT ON user_groups
FOR EACH ROW
  BEGIN
    SELECT
      current_timestamp,current_timestamp INTO :new.created_ts, :new.updated_ts
    FROM   dual;
  END;
/

-- Triggers for USERS table
-- Will generate user_id from U0001 to U9999
CREATE OR REPLACE TRIGGER users_generator
BEFORE INSERT ON users
FOR EACH ROW
  DECLARE
    last_id users.user_id%TYPE;
    last_id_n NUMBER;
    rec_count NUMBER;
  BEGIN
    SELECT count(1) INTO rec_count FROM USERS;
    IF rec_count = 0
    THEN
      last_id_n:=0;
    ELSE
      select TO_NUMBER(substr(USER_ID,2))INTO last_id_n from USERS where CREATED_TS = (SELECT max(CREATED_TS) from USERS);
    END IF;
    select ('U'||lpad(last_id_n+1,4,'0')) INTO last_id from dual;
    SELECT last_id
    INTO   :new.USER_ID
    FROM   dual;
  END;
/

CREATE OR REPLACE TRIGGER USERS_UPDATE_TRIGGER
BEFORE UPDATE ON USERS
FOR EACH ROW
  BEGIN
    SELECT current_timestamp
    INTO   :new.updated_ts
    FROM   dual;
  END;
/

CREATE OR REPLACE TRIGGER USERS_INSERT_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
  BEGIN
    SELECT
      current_timestamp,current_timestamp INTO :new.created_ts, :new.updated_ts
    FROM   dual;
  END;
/

-- Triggers for USER_LOGIN table
CREATE OR REPLACE TRIGGER USERS_LOGIN_UPDATE_TRIGGER
BEFORE UPDATE ON USER_LOGIN
FOR EACH ROW
  BEGIN
    SELECT current_timestamp
    INTO   :new.updated_ts
    FROM   dual;
  END;
/

CREATE OR REPLACE TRIGGER USER_LOGIN_INSERT_TRIGGER
BEFORE INSERT ON USER_LOGIN
FOR EACH ROW
  BEGIN
    SELECT
      current_timestamp,current_timestamp INTO :new.created_ts, :new.updated_ts
    FROM   dual;
  END;
/

-- Trigger for USER_ROLE table
CREATE OR REPLACE TRIGGER USERS_ROLE_UPDATE_TRIGGER
BEFORE UPDATE ON USER_ROLE
FOR EACH ROW
  BEGIN
    SELECT current_timestamp
    INTO   :new.updated_ts
    FROM   dual;
  END;
/

CREATE OR REPLACE TRIGGER USER_ROLE_INSERT_TRIGGER
BEFORE INSERT ON USER_ROLE
FOR EACH ROW
  BEGIN
    SELECT
      current_timestamp,current_timestamp INTO :new.created_ts, :new.updated_ts
    FROM   dual;
  END;
/

