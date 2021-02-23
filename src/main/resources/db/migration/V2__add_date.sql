INSERT INTO `blog`.`users`(`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('1', 'ivan@mail.ru', '1', 'Ivan', 'qwerty', '20201112');
INSERT INTO `blog`.`users`(`email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('petr@mail.ru', '1', 'Petr', 'qwerty', '20201114');

INSERT INTO `blog`.`posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', '1', 'NEW', 'Пост 1', '20201123', 'Пост №1', '1', '1');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 2 #SkillBox', '20201020', 'Пост №21', '1', '2');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 3 #Oracle', '20201121', 'Пост №3', '1', '3');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 4 #Oracle', '20201222', 'Пост №4', '1', '4');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 5 #Oracle #SkillBox', '20201123', 'Пост №5', '1', '5');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 6', '20201124', 'Пост №6', '1', '6');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 7', '20201125', 'Пост №7', '1', '7');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 8', '20201126', 'Пост №8', '1', '8');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 9', '20201127', 'Пост №9', '1', '9');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 10', '20200928', 'Пост №10', '1', '10');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 11', '20201130', 'Пост №11', '1', '11');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'NEW', 'Пост 12 второй пользователь', '20201101', 'Пост №12', '2', '12');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 13 второй пользователь #SkillBox', '20201102', 'Пост №13', '2', '13');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 14 второй пользователь #SkillBox', '20201103', 'Пост №14', '2', '14');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'DECLINED', '1', 'Пост 15 второй пользователь #Oracle', '20201104', 'Пост №15', '2', '14');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 16 второй пользователь #Oracle', '20201205', 'Пост №16', '2', '130');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 17 второй пользователь #Oracle #SkillBox', '20201106', 'Пост №17', '2', '140');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 18 второй пользователь #Java', '20201107', 'Пост №18', '2', '110');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 19 второй пользователь #Java', '20201108', 'Пост №19', '2', '145');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 20 второй пользователь #Python #Java', '20201109', 'Пост №20', '2', '111');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 21 второй пользователь #Python #Oracle', '20201110', 'Пост №21', '2', '144');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 22 второй пользователь #Python #SkillBox', '20201111', 'Пост №22', '2', '139');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 23 второй пользователь #Python', '20201112', 'Пост №23', '2', '142');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 24 второй пользователь #Python', '20201113', 'Пост №24', '2', '137');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 25 второй пользователь #Python', '20201114', 'Пост №25', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 26 второй пользователь #Python', '20191114', 'Пост №26', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 27 второй пользователь #Python', '20210114', 'Пост №27', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 28 второй пользователь #Python', '20210114', 'Пост №28', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 29 второй пользователь #Python', '20191114', 'Пост №29', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 30 второй пользователь #Python', '20201114', 'Пост №30', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 31 второй пользователь #Python', '20210115', 'Пост №31', '2', '148');
INSERT INTO `blog`.`posts` (`is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', 'ACCEPTED', '1', 'Пост 32 второй пользователь #Python', '20210215', 'Пост №32', '2', '148');



--INSERT INTO `blog`.`post_comments` (`id`, `parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('1', '12', '13', 'комментарий к посту №1', '20201124', '2');
--INSERT INTO `blog`.`post_comments` (`parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('12', '13', 'комментарий к посту №2', '20201121', '2');
--INSERT INTO `blog`.`post_comments` (`parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('12', '13', 'комментарий к посту №3', '20201122', '2');
--INSERT INTO `blog`.`post_comments` (`parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('12', '13', 'комментарий к посту №12', '20201125', '1');
--INSERT INTO `blog`.`post_comments` (`parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('12', '13', 'комментарий к посту №13', '20201125', '1');
--INSERT INTO `blog`.`post_comments` (`parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('12', '13', 'комментарий к посту №13', '20201125', '1');
--INSERT INTO `blog`.`post_comments` (`parent_id`, `post_id`, `text`, `time`, `user_id`) VALUES ('12', '14', 'комментарий к посту №14', '20201125', '1');

INSERT INTO `blog`.`post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('1', '13', 'комментарий к посту №1', '20201124', '2');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('13', 'комментарий к посту №2', '20201121', '2');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('13', 'комментарий к посту №3', '20201122', '2');
INSERT INTO `blog`.`post_comments` (`post_id`, `text`, `time`, `user_id`) VALUES ('13', 'комментарий к посту №12', '20201125', '1');
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

INSERT INTO `blog`.`tag2post` (`id`, `post_id`, `tag_id`) VALUES ('1', '2', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('3', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('4', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('5', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('5', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('13', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('14', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('15', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('16', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('17', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('17', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('18', '3');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('19', '3');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('20', '4');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('20', '3');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('21', '4');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('21', '2');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('22', '4');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('22', '1');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('23', '4');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('24', '4');
INSERT INTO `blog`.`tag2post` (`post_id`, `tag_id`) VALUES ('25', '4');








INSERT INTO `blog`.`global_settings` (`id`, `code`, `name`, `value`) VALUES ('1', 'MULTIUSER_MODE', 'Многопользовательский режим', 'YES');
INSERT INTO `blog`.`global_settings` (`code`, `name`, `value`) VALUES ('POST_PREMODERATION', 'Премодерация постов', 'NO');
INSERT INTO `blog`.`global_settings` (`code`, `name`, `value`) VALUES ('STATISTICS_IS_PUBLIC', 'Показывать всем статистику блога', 'YES');






--INSERT INTO blog.users (id, email, is_moderator, name, password, reg_time) VALUES ('1', 'ivan@mail.ru', '1', 'Ivan', 'qwerty', '20201112');
