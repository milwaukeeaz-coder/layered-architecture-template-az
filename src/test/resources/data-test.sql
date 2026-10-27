CREATE TABLE ITEM_SEQ_LOCK (id INT PRIMARY KEY);
INSERT INTO ITEM_SEQ_LOCK(id) VALUES (1);
INSERT INTO ITEM (id, name) VALUES
    (1, 'Item A'),
    (2, 'Item B'),
    (3, 'Item C');
ALTER SEQUENCE ITEM_SEQ RESTART WITH (SELECT MAX(id) + 1 FROM item);
INSERT INTO AUDIT_LOG (id, username, action, risk_score) VALUES
    (1, 'user-a', 'LOGIN_FAILED', 80),
    (2, 'user-a', 'PRIVILEGE_CHANGE', 90),
    (3, 'user-a', 'DATA_EXPORT', 75),
    (4, 'user-b', 'LOGIN_FAILED', 95),
    (5, 'user-b', 'LOGIN_FAILED', 88),
    (6, 'user-c', 'PAGE_VIEW', 10),
    (7, 'user-c', 'PAGE_VIEW', 12),
    (8, 'user-c', 'PAGE_VIEW', 11),
    (9, 'user-d', 'LOGIN_FAILED', 70),
    (10, 'user-d', 'LOGIN_FAILED', 71),
    (11, 'user-d', 'LOGIN_FAILED', 72);
ALTER SEQUENCE AUDIT_LOG_SEQ RESTART WITH (SELECT MAX(id) + 1 FROM AUDIT_LOG);