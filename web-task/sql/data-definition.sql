CREATE TABLE `web-task`.`CLIENT_CONNECTIONS`(
'id' int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
'connectionSource' varchar(12) NOT NULL DEFAULT '',
'connectionTime' DATE  NOT NULL,
'clientAgent' varchar(100) NOT NULL DEFAULT '',
CONSTRAINT PRIMARY KEY ('id')
)
