insert into Author (AUTHOR_NAME, AUTHOR_EMAIL, AUTHOR_PASSWORD) VALUES ('Anna','Anna@Steppins.com','admin');
insert into Author (AUTHOR_NAME, AUTHOR_EMAIL, AUTHOR_PASSWORD) VALUES ('Steve','Steve@Steppins.com','admin');
insert into Author (AUTHOR_NAME, AUTHOR_EMAIL, AUTHOR_PASSWORD) VALUES ('Nyamo','Nyamo@Steppins.com','admin');

insert into KEYWORD (KEYWORD_NAME, KEYWORD_COLOR) VALUES ('Java','#00CCFF');
insert into KEYWORD (KEYWORD_NAME, KEYWORD_COLOR) VALUES ('SQL','#808080');
insert into KEYWORD (KEYWORD_NAME, KEYWORD_COLOR) VALUES ('HTML','#008000');
insert into KEYWORD (KEYWORD_NAME, KEYWORD_COLOR) VALUES ('CSS','#FF6600');
insert into KEYWORD (KEYWORD_NAME, KEYWORD_COLOR) VALUES ('JavaScript','#800080');

insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('Titletest','Codetest','Descriptiontest','outputTest','SourceTest','1');

insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('AnnaSQLTitle','SQLCodebyAnna','SQLdescriptionbyAnna','SQLOutputbyAnna', 'SQLSourcebyAnna','1');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('AnnaJavaTitle','JavaCodebyAnna','JavadescriptionbyAnna','javaoutputbyAnna','javaSourcebyAnna','1');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('AnnaJavaScriptTitle','JavaScriptcodebyAnna','JavaScriptdescriptionbyAnna','JavaScriptoutputbyAnna','JavaScriptSourcebyAnna','1');

insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('SteveSQLTitle','SQLCodebySteve','SQLdescriptionbySteve','SQLOutputbySteve', 'SQLSourcebySTeve','2');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('SteveJavaTitle','JavaCodebySteve','JavadescriptionbySteve','javaoutputbySteve','javaSourcebySteve','2');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('SteveJavaScriptTitle','JavaScriptcodebySteve','JavaScriptdescriptionbySteve','JavaScriptoutputbySteve','JavaScriptSourcebySteve','2');

insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('NyamoSQLTitle','SQLCodebyNyamo','SQLdescriptionbyNyamo','SQLOutputbyNyamo', 'SQLSourcebyNyamo','3');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('NyamoJavaTitle','JavaCodebyNyamo','JavadescriptionbyNyamo','javaoutputbyNyamo','javaSourcebyNyamo','3');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('NyamoJavaScriptTitle','JavaScriptcodebyNyamo','JavaScriptdescriptionbyNyamo','JavaScriptoutputbyNyamo','JavaScriptSourcebyNyamo','3');
insert into post (POST_TITLE, POST_CODE, POST_DESCRIPTION,POST_OUTPUT,POST_SOURCE, AUTHOR_ID) VALUES ('HTML/CSS/JSbyAnnaTitle','HTML/CSS/JSbyAnnaCode','HTML/CSS/JSbyAnnadescription','HTML/CSS/JSbyAnnaoutput','HTML/CSS/JSbyAnnaSource','1');

insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('2','2');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('1','3');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('1','4');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('1','5');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('3','1');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('4','5');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('5','2');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('6','1');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('7','5');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('8','2');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('9','1');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('10','5');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('11','3');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('11','4');
insert into POST_KEYWORD (POST_ID, KEYWORD_ID) values ('11','5');

--select * from author;
--select * from post;
--select * from Keyword;
SELECT                      dbo.POST.POST_ID, dbo.POST.POST_TITLE, dbo.KEYWORD.KEYWORD_NAME, dbo.KEYWORD.KEYWORD_ID
FROM                         dbo.KEYWORD INNER JOIN
                                      dbo.POST_KEYWORD ON dbo.KEYWORD.KEYWORD_ID = dbo.POST_KEYWORD.KEYWORD_ID RIGHT OUTER JOIN
                                      dbo.AUTHOR INNER JOIN
                                      dbo.POST ON dbo.AUTHOR.AUTHOR_ID = dbo.POST.AUTHOR_ID ON dbo.POST_KEYWORD.POST_ID = dbo.POST.POST_ID
