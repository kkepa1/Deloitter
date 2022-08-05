USE deloitter;

CREATE TABLE users
(
    id       serial,
    login    text not null,
    password text not null,

    CONSTRAINT pk_users PRIMARY KEY (id)
);

INSERT INTO users (id, login, password) VALUES
                                            (1, 'random1', 'random_password1'),
                                            (2, 'random2', 'random_password2');

CREATE TABLE dwitts
(
    id      serial,
    content text not null,
    user_id bigint unsigned,

    CONSTRAINT pk_dwitts PRIMARY KEY (id),
    CONSTRAINT fk_dwitts_users FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO dwitts (id, content, user_id)VALUES
                                    ('1', 'first_dwitt_from_first_user', '1'),
                                    ('2', 'second_dwitt_from_first_user', '1'),
                                    ('3', 'first_dwitt_from_second_user', '2'),
                                    ('4', 'second_dwitt_from_second_user', '2');

CREATE TABLE comments
(
    id       serial,
    content  text not null,
    user_id  bigint unsigned,
    dwitt_id bigint unsigned,

    CONSTRAINT pk_comments PRIMARY KEY (id),
    CONSTRAINT fk_comments_users FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_comments_dwitts FOREIGN KEY (dwitt_id) REFERENCES dwitts (id)
);

INSERT INTO comments (id, content, user_id, dwitt_id) VALUES
                         (1, 'first_user_first_dwitt_comment', 1, 1),
                         (2, 'second_user_second_dwitt_comment', 2, 2),
                         (3, 'first_user_second_dwitt_comment', 1, 2),
                         (4, 'second_user_third_dwitt_comment', 2, 3);
