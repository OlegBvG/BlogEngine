INSERT INTO `users`(`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('1', 'ivan@mail.ru', '1', 'Ivan', '$2a$12$uThNM41uIKvna2mam5U7vOtjAaQtCrWztGu20ywS4IONMIwu8WjNK', '20201112');
INSERT INTO `users`(`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('2', 'petr@mail.ru', '1', 'Petr', '$2a$12$uThNM41uIKvna2mam5U7vOtjAaQtCrWztGu20ywS4IONMIwu8WjNK', '20201114');
INSERT INTO `users`(`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) VALUES ('3', 'vasya@mail.ru', '0', 'Vasya', '$2a$12$uThNM41uIKvna2mam5U7vOtjAaQtCrWztGu20ywS4IONMIwu8WjNK', '20201114');

INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('1', '1', 'NEW', 'Пост 1', '20201123', 'Пост №1', '1', '1');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('2', '1', 'NEW', 'Пост 2 #SkillBox', '20201020', 'Пост №21', '1', '2');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('3', '1', 'NEW', 'Пост 3 #Oracle', '20201121', 'Пост №3', '1', '3');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('4', '1', 'NEW', 'Пост 4 #Oracle', '20201222', 'Пост №4', '1', '4');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('5', '1', 'NEW', 'Пост 5 #Oracle #SkillBox', '20201123', 'Пост №5', '1', '5');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('6', '1', 'NEW', 'Пост 6', '20201124', 'Пост №6', '1', '6');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('7', '1', 'NEW', 'Пост 7', '20201125', 'Пост №7', '1', '7');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('8', '1', 'NEW', 'Пост 8', '20201126', 'Пост №8', '1', '8');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('9', '1', 'NEW', 'Пост 9', '20201127', 'Пост №9', '1', '9');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('10', '1', 'NEW', 'Пост 10', '20200928', 'Пост №10', '1', '10');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('11', '1', 'NEW', 'Пост 11', '20201130', 'Пост №11', '1', '11');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('12', '1', 'NEW', 'Пост 12 второй пользователь', '20201101', 'Пост №12', '2', '12');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('13', '1', 'ACCEPTED', '1', 'Пост 13 второй пользователь #SkillBox', '20201102', 'Пост №13', '2', '13');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('14', '1', 'ACCEPTED', '1', 'Пост 14 второй пользователь #SkillBox', '20201103', 'Пост №14', '2', '14');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('15', '1', 'DECLINED', '1', 'Пост 15 второй пользователь #Oracle', '20201104', 'Пост №15', '2', '14');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('16', '1', 'ACCEPTED', '1', 'Пост 16 второй пользователь #Oracle', '20201205', 'Пост №16', '2', '130');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('17', '1', 'ACCEPTED', '1', 'Пост 17 второй пользователь #Oracle #SkillBox', '20201106', 'Пост №17', '2', '140');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('18', '1', 'ACCEPTED', '1', 'Пост 18 второй пользователь #Java', '20201107', 'Пост №18', '2', '110');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('19', '1', 'ACCEPTED', '1', 'Пост 19 второй пользователь #Java', '20201108', 'Пост №19', '2', '145');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('20', '1', 'ACCEPTED', '1', 'Пост 20 второй пользователь #Python #Java', '20201109', 'Пост №20', '2', '111');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('21', '1', 'ACCEPTED', '1', 'Пост 21 второй пользователь #Python #Oracle', '20201110', 'Пост №21', '2', '144');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('22', '1', 'ACCEPTED', '1', 'Пост 22 второй пользователь #Python #SkillBox', '20201111', 'Пост №22', '2', '139');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('23', '1', 'ACCEPTED', '1', 'Пост 23 второй пользователь #Python', '20201112', 'Пост №23', '2', '142');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('24', '1', 'ACCEPTED', '1', 'Пост 24 второй пользователь #Python', '20201113', 'Пост №24', '2', '137');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('25', '1', 'ACCEPTED', '1', 'Пост 25 второй пользователь #Python', '20201114', 'Пост №25', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('26', '1', 'ACCEPTED', '1', 'Пост 26 второй пользователь #Python', '20191114', 'Пост №26', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('27', '1', 'ACCEPTED', '1', 'Пост 27 второй пользователь #Python', '20210114', 'Пост №27', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('28', '1', 'ACCEPTED', '1', 'Пост 28 второй пользователь #Python', '20210114', 'Пост №28', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('29', '1', 'ACCEPTED', '1', 'Пост 29 второй пользователь #Python', '20191114', 'Пост №29', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('30', '1', 'ACCEPTED', '1', 'Пост 30 второй пользователь #Python', '20201114', 'Пост №30', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('31', '1', 'ACCEPTED', '1', 'Пост 31 второй пользователь #Python', '20210115', 'Пост №31', '2', '148');
INSERT INTO `posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `user_id`, `view_count`) VALUES ('32', '1', 'ACCEPTED', '1', 'Пост 32 второй пользователь #Python', '20210215', 'Пост №32', '2', '148');


INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('1', '13', 'комментарий к посту №1', '20201124', '2');
INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('2', '13', 'комментарий к посту №2', '20201121', '2');
INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('3', '13', 'комментарий к посту №3', '20201122', '2');
INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('4', '13', 'комментарий к посту №12', '20201125', '1');
INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('5', '13', 'комментарий к посту №13', '20201125', '1');
INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('6', '13', 'комментарий к посту №13', '20201125', '1');
INSERT INTO `post_comments` (`id`, `post_id`, `text`, `time`, `user_id`) VALUES ('7', '14', 'комментарий к посту №14', '20201125', '1');



INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('1', '1', '20201201', '2', '1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('2', '1', '20201202', '2', '1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('3', '2', '20201203', '2', '1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('4', '3', '20201203', '2', '1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('5', '3', '20201203', '2', '1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('6', '4', '20201203', '2', '-1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('7', '4', '20201203', '2', '-1');
INSERT INTO `post_votes` (`id`, `post_id`, `time`, `user_id`, `value`) VALUES ('8', '5', '20201204', '1', '-1');

INSERT INTO `tags` (`id`, `name`) VALUES ('1', 'SkillBox');
INSERT INTO `tags` (`id`, `name`) VALUES ('2', 'Oracle');
INSERT INTO `tags` (`id`, `name`) VALUES ('3', 'Java');
INSERT INTO `tags` (`id`, `name`) VALUES ('4', 'Python');

INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('1', '2', '1');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('2', '3', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('3', '4', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('4', '5', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('5', '5', '1');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('6', '13', '1');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('7', '14', '1');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('8', '15', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('9', '16', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('10', '17', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('11', '17', '1');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('12', '18', '3');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('13', '19', '3');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('14', '20', '4');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('15', '20', '3');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('16', '21', '4');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('17', '21', '2');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('18', '22', '4');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('19', '22', '1');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('20', '23', '4');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('21', '24', '4');
INSERT INTO `tag2post` (`id`, `post_id`, `tag_id`) VALUES ('22', '25', '4');


INSERT INTO `global_settings` (`id`, `code`, `name`, `value`) VALUES ('1', 'MULTIUSER_MODE', 'Многопользовательский режим', 'YES');
INSERT INTO `global_settings` (`id`, `code`, `name`, `value`) VALUES ('2', 'POST_PREMODERATION', 'Премодерация постов', 'NO');
INSERT INTO `global_settings` (`id`, `code`, `name`, `value`) VALUES ('3', 'STATISTICS_IS_PUBLIC', 'Показывать всем статистику блога', 'YES');


INSERT INTO hibernate_sequence (next_val) VALUES (0);






