INSERT INTO users (username, password, enabled, email) VALUES ('test', '$2a$12$aoyOCxY0e1LmiTSAV4hQtelwLwLURBdeSLGH1oibivgSslWjI0dSa', true, 'test@testing.tst');
INSERT INTO authorities (id, username, authority) VALUES (3001, 'test', 'ROLE_USER');
INSERT INTO authorities (id, username, authority) VALUES (3002, 'test', 'ROLE_ADMIN');
