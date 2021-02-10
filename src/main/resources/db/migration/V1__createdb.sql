
--
-- Table structure for table `captcha_codes`
--

DROP TABLE IF EXISTS `captcha_codes`;

CREATE TABLE `captcha_codes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` tinyint(4) NOT NULL,
  `secret_code` tinyint(4) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `global_settings`
--

DROP TABLE IF EXISTS `global_settings`;

CREATE TABLE `global_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `post_comments`
--

DROP TABLE IF EXISTS `post_comments`;

CREATE TABLE `post_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `post_id` int(11) NOT NULL,
  `text` text NOT NULL,
  `time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_post_id` (`post_id`),
  KEY `FK_user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `post_votes`
--

DROP TABLE IF EXISTS `post_votes`;

CREATE TABLE `post_votes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `value` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_post_id` (`post_id`),
  KEY `FK_user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` tinyint(4) NOT NULL,
  `moderation_status` enum('NEW','ACCEPTED','DECLINED') NOT NULL,
  `moderator_id` int(11),
  `text` text NOT NULL,
  `time` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `view_count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `tag2post`
--

DROP TABLE IF EXISTS `tag2post`;

CREATE TABLE `tag2post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
  KEY `FK_post_to_tag` (`post_id`,`tag_id`),
  KEY `FK_tag_id` (`tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `is_moderator` tinyint(4) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `photo` text,
  `reg_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;








--drop table if exists captcha_codes;
--drop table if exists global_settings;
--drop table if exists hibernate_sequence;
--drop table if exists post_comments;
--drop table if exists post_votes;
--drop table if exists posts;
--drop table if exists tag2post;
--drop table if exists tags;
--drop table if exists users;
--create table captcha_codes (id integer not null, code TINYINT not null, secret_code TINYINT not null, time DATETIME not null, primary key (id)) ;
--create table global_settings (id integer not null, code varchar(255) not null, name varchar(255) not null, value varchar(255) not null, primary key (id));
----create table hibernate_sequence (next_val bigint) engine=MyISAM
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
----insert into hibernate_sequence values ( 1 )
--create table post_comments (id integer not null, parent_id integer, post_id integer not null, text TEXT not null, time datetime not null, user_id integer not null, primary key (id)) engine=MyISAM
--create table post_votes (id integer not null, post_id integer not null, time DATETIME not null, user_id integer not null, value TINYINT not null, primary key (id)) engine=MyISAM
--create table posts (id integer not null, is_active TINYINT not null, moderation_status ENUM('NEW', 'ACCEPTED', 'DECLINED') not null, moderator_id integer not null, text TEXT not null, time datetime not null, title varchar(255) not null, user_id integer not null, view_count integer not null, primary key (id)) engine=MyISAM
--create table tag2post (id integer not null, post_id integer not null, tag_id integer not null, primary key (post_id, tag_id)) engine=MyISAM
--create table tags (id integer not null, name varchar(255) not null, primary key (id)) engine=MyISAM
--create table users (id integer not null, code varchar(255), email varchar(255) not null, is_moderator TINYINT not null, name varchar(255) not null, password varchar(255) not null, photo TEXT, reg_time datetime not null, primary key (id)) engine=MyISAM
--alter table post_comments add constraint FKaawaqxjs3br8dw5v90w7uu514 foreign key (post_id) references posts (id)
--alter table post_comments add constraint FKsnxoecngu89u3fh4wdrgf0f2g foreign key (user_id) references users (id)
--alter table post_votes add constraint FK9jh5u17tmu1g7xnlxa77ilo3u foreign key (post_id) references posts (id)
--alter table post_votes add constraint FK9q09ho9p8fmo6rcysnci8rocc foreign key (user_id) references users (id)
--alter table posts add constraint FK5lidm6cqbc7u4xhqpxm898qme foreign key (user_id) references users (id)
--alter table tag2post add constraint FKjou6suf2w810t2u3l96uasw3r foreign key (tag_id) references tags (id)
--alter table tag2post add constraint FKpjoedhh4h917xf25el3odq20i foreign key (post_id) references posts (id)
