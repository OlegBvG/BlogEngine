INSERT INTO `blog`.`users`(`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('1', 'ivan@mail.ru', '1', 'Ivan', 'qwerty', '20201112');
INSERT INTO `blog`.`users`(`email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('petr@mail.ru', '1', 'Petr', 'qwerty', '20201114');

INSERT INTO `blog`.`posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', '1', 'NEW', 'Пост 1', '20201123', 'Пост №1', '1', '1');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 2', '20201123', 'Пост №21', '1', '2');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 3', '20201123', 'Пост №3', '1', '3');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 4', '20201123', 'Пост №4', '1', '4');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 5', '20201123', 'Пост №5', '1', '5');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 6', '20201123', 'Пост №6', '1', '6');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 7', '20201123', 'Пост №7', '1', '7');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 8', '20201123', 'Пост №8', '1', '8');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 9', '20201123', 'Пост №9', '1', '9');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 10', '20201123', 'Пост №10', '1', '10');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 11', '20201123', 'Пост №11', '1', '11');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 12 второй пользователь', '20201123', 'Пост №12', '2', '12');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 13 второй пользователь', '20201123', 'Пост №13', '2', '13');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 14 второй пользователь', '20201123', 'Пост №14', '2', '14');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'DECLINED', '1', 'Пост 15 второй пользователь', '20201123', 'Пост №15', '2', '14');

INSERT INTO `blog`.`post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('1', '1', 'комментарий к посту №1', '20201124', '2');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('2', 'комментарий к посту №2', '20201121', '2');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('3', 'комментарий к посту №3', '20201122', '2');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('12', 'комментарий к посту №12', '20201125', '1');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('13', 'комментарий к посту №13', '20201125', '1');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('13', 'комментарий к посту №13', '20201125', '1');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('14', 'комментарий к посту №14', '20201125', '1');

INSERT INTO `blog`.`post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('1', '1', '20201201', '2', '1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('2', '20201202', '2', '1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('3', '20201203', '2', '1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('13', '20201203', '2', '1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('14', '20201203', '2', '1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('13', '20201203', '2', '-1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('14', '20201203', '2', '-1');
INSERT INTO `blog`.`post_votes` (`post_id`, `time`, `user_id`, `value`) VALUES ('12', '20201204', '1', '-1');

INSERT INTO `blog`.`tags` (`id`, `name`) VALUES ('1', 'SkillBox');
INSERT INTO `blog`.`tags` (`name`) VALUES ('Oracle');
INSERT INTO `blog`.`tags` (`name`) VALUES ('Java');
INSERT INTO `blog`.`tags` (`name`) VALUES ('Python');

INSERT INTO `blog`.`tag2post` (`id`, `post_id`, `tag_id`) VALUES ('1', '1', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('2', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('3', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('4', '3');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('12', '4');

INSERT INTO `blog`.`global_settings` (`id`, `code`, `name`, `value`) VALUES ('1', 'MULTIUSER_MODE', 'Многопользовательский режим', 'YES');
INSERT INTO `blog`.`global_settings` (`code`, `name`, `value`) VALUES ('POST_PREMODERATION', 'Премодерация постов', 'NO');
INSERT INTO `blog`.`global_settings` (`code`, `name`, `value`) VALUES ('STATISTICS_IS_PUBLIC', 'Показывать всем статистику блога', 'YES');






--INSERT INTO blog.users (id, email, is_moderator, name, password, reg_time) VALUES ('1', 'ivan@mail.ru', '1', 'Ivan', 'qwerty', '20201112');
