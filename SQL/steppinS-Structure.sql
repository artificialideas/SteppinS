CREATE DATABASE SteppinS
GO
USE SteppinS
GO
CREATE TABLE AUTHOR(
AUTHOR_ID int IDENTITY(1,1) NOT NULL,
AUTHOR_NAME varchar(20) NOT NULL UNIQUE,
AUTHOR_EMAIL varchar(60) NOT NULL UNIQUE,
AUTHOR_PASSWORD varchar (25) NOT NULL,
	CONSTRAINT PK_AUTHOR_ID PRIMARY KEY NONCLUSTERED 
	(
		AUTHOR_ID ASC
	)
)
GO

CREATE TABLE KEYWORD(
KEYWORD_ID int IDENTITY(1,1) NOT NULL,
KEYWORD_NAME varchar(15) NOT NULL UNIQUE,
KEYWORD_COLOR varchar(10) NULL UNIQUE,
CONSTRAINT PK_KEYWORD_ID PRIMARY KEY NONCLUSTERED 
	(
		KEYWORD_ID ASC
	)
)
GO

CREATE TABLE POST(
	POST_ID int IDENTITY(1,1) NOT NULL,
	POST_TITLE varchar(60) NOT NULL,
	POST_CODE varchar(1500) NOT NULL,
	POST_DESCRIPTION varchar(600) NOT NULL,
	POST_OUTPUT varchar(300) NULL,
	POST_SOURCE varchar(100) NULL,
	POST_TIMESTAMP DATETIME NOT NULL,
	AUTHOR_ID int NOT NULL,
	CONSTRAINT PK_POST_ID PRIMARY KEY NONCLUSTERED (POST_ID ASC)
)
GO

CREATE TABLE POST_KEYWORD(
POST_ID int NOT NULL,
KEYWORD_ID int NOT NULL,
CONSTRAINT PK_POST_KEYWORD PRIMARY KEY NONCLUSTERED 
	(
		POST_ID ASC,
		KEYWORD_ID ASC)
)
GO

ALTER TABLE POST WITH CHECK ADD CONSTRAINT FK_POST_AUTHOR FOREIGN KEY(AUTHOR_ID)
REFERENCES AUTHOR (AUTHOR_ID)
GO

ALTER TABLE POST_KEYWORD ADD CONSTRAINT FK_POST_KEYWORD_KEYWORD FOREIGN KEY(KEYWORD_ID)
REFERENCES KEYWORD (KEYWORD_ID)
GO

ALTER TABLE POST_KEYWORD ADD CONSTRAINT FK_POST_KEYWORD_POST FOREIGN KEY (POST_ID)
REFERENCES POST (POST_ID)
ALTER TABLE POST ADD CONSTRAINT DF_TIMESTAMP default (getdate()) for POST_TIMESTAMP
GO
