DROP TABLE BANK;
CREATE TABLE BANK(ACCOUNTNUMBER NUMBER(10) PRIMARY KEY,CID NVERCHAR2(20) NOT NULL,CPW NVERCHAR2(20), CNAME NVARCHAR2(5) NOT NULL,SECURITYNUMBER NVARCHAR2(13),BALANCE NUMBER(15) DEFAULT 0);
CREATE TABLE SECURITYCARD(CARD1 NUMBER(2),CARD2 NUMBER(2),CARD3 NUMBER(2),CARD4 NUMBER(2),CARD5 NUMBER(2),CARD6 NUMBER(2),CARD7 NUMBER(2),CARD8 NUMBER(2),CARD9 NUMBER(2));
SELECT COUNT(*) FROM BANK;

SELECT * FROM BANK;