

INSERT INTO account (id, username, domain, display_name, locked, created_at, note, url, avatar, avatar_static, header, header_static, moved_to_account_id, actor_type) VALUES (28423, 'dougc', null, 'Doug', false, '2018-01-03 16:46:33', '\u003cp\u003e\u003ca href=\"https://functional.cafe/tags/scala\" class=\"mention hashtag\" rel=\"tag\"\u003e#\u003cspan\u003escala\u003c/span\u003e\u003c/a\u003e \u003ca href=\"https://functional.cafe/tags/uk\" class=\"mention hashtag\" rel=\"tag\"\u003e#\u003cspan\u003euk\u003c/span\u003e\u003c/a\u003e\u003c/p\u003e', 'https://functional.cafe/@dougc', 'https://functional.cafe/system/accounts/avatars/000/028/423/original/87875d20b0d157c3.jpg?1515267771', 'https://functional.cafe/system/accounts/avatars/000/028/423/original/87875d20b0d157c3.jpg?1515267771', 'https://functional.cafe/headers/original/missing.png', 'https://functional.cafe/headers/original/missing.png', null, 'Person');
INSERT INTO account (id, username, domain, display_name, locked, created_at, note, url, avatar, avatar_static, header, header_static, moved_to_account_id, actor_type) VALUES (1, 'dougc1', null, 'Doug', false, '2018-01-03 16:46:33', '\u003cp\u003e\u003ca href=\"https://functional.cafe/tags/scala\" class=\"mention hashtag\" rel=\"tag\"\u003e#\u003cspan\u003escala\u003c/span\u003e\u003c/a\u003e \u003ca href=\"https://functional.cafe/tags/uk\" class=\"mention hashtag\" rel=\"tag\"\u003e#\u003cspan\u003euk\u003c/span\u003e\u003c/a\u003e\u003c/p\u003e', 'https://functional.cafe/@dougc', 'https://functional.cafe/system/accounts/avatars/000/028/423/original/87875d20b0d157c3.jpg?1515267771', 'https://functional.cafe/system/accounts/avatars/000/028/423/original/87875d20b0d157c3.jpg?1515267771', 'https://functional.cafe/headers/original/missing.png', 'https://functional.cafe/headers/original/missing.png', null, 'Person');
INSERT INTO account (id, username, domain, display_name, locked, created_at, note, url, avatar, avatar_static, header, header_static, moved_to_account_id, actor_type) VALUES (2, 'dougc2', null, 'Doug', false, '2018-01-03 16:46:33', '\u003cp\u003e\u003ca href=\"https://functional.cafe/tags/scala\" class=\"mention hashtag\" rel=\"tag\"\u003e#\u003cspan\u003escala\u003c/span\u003e\u003c/a\u003e \u003ca href=\"https://functional.cafe/tags/uk\" class=\"mention hashtag\" rel=\"tag\"\u003e#\u003cspan\u003euk\u003c/span\u003e\u003c/a\u003e\u003c/p\u003e', 'https://functional.cafe/@dougc', 'https://functional.cafe/system/accounts/avatars/000/028/423/original/87875d20b0d157c3.jpg?1515267771', 'https://functional.cafe/system/accounts/avatars/000/028/423/original/87875d20b0d157c3.jpg?1515267771', 'https://functional.cafe/headers/original/missing.png', 'https://functional.cafe/headers/original/missing.png', null, 'Person');

INSERT INTO follow (follower_id, followed_id) VALUES (28423, 1);
INSERT INTO follow (follower_id, followed_id) VALUES (28423, 2);
INSERT INTO follow (follower_id, followed_id) VALUES (1, 28423);

INSERT INTO status
    (text, created_at, account_id)
VALUES
       ('first status!', now(), 28423);