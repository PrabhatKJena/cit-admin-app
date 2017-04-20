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
      current_timestamp,current_timestamp INTO :new.create_ts, :new.updated_ts
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
      current_timestamp,current_timestamp INTO :new.create_ts, :new.updated_ts
    FROM   dual;
  END;
/
