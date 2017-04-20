-- static data for USER_GROUPS
INSERT INTO USER_GROUPS (GROUP_NAME,group_value,GROUP_DESC) VALUES ('ADMIN', 1, 'Admin group will have all Admin resources');
INSERT INTO USER_GROUPS (GROUP_NAME,group_value,GROUP_DESC) VALUES ('RECRUITER',2, 'This group will have only access to Consultant and Client resources');
INSERT INTO USER_GROUPS (GROUP_NAME,group_value,GROUP_DESC) VALUES ('FINANCE',4, 'This group will have access to Financial resources');
INSERT INTO USER_GROUPS (GROUP_NAME,group_value,GROUP_DESC) VALUES ('ALL',7, 'This is the super user having access to all resources');