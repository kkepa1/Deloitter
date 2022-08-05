CREATE TABLE users
(
    id       int(11) NOT NULL,
    login    text not null,
    password text not null
);

INSERT INTO users (id, login, password) VALUES
                                            (1, 'random1', 'random_password1'),
                                            (2, 'random2', 'random_password2');

CREATE TABLE user_dwitt (
                            user_id int(11) NOT NULL,
                            dwitt_id int(11) NOT NULL
);

INSERT INTO user_dwitt (user_id, dwitt_id) VALUES
                                               (1, 1),
                                               (1, 2),
                                               (2, 3),
                                               (2, 4);

CREATE TABLE dwitts
(
    id      int(11) NOT NULL,
    content text not null
);

INSERT INTO dwitts (id, content)VALUES
                                    ('1', 'first_dwitt_from_first_user'),
                                    ('2', 'second_dwitt_from_first_user'),
                                    ('3', 'first_dwitt_from_second_user'),
                                    ('4', 'second_dwitt_from_second_user');

CREATE TABLE dwitt_comment (
                               dwitt_id int(11) NOT NULL,
                               comment_id int(11) NOT NULL
);

INSERT INTO dwitt_comment (dwitt_id, comment_id) VALUES
                                                     (1, 1),
                                                     (2, 2),
                                                     (2, 3),
                                                     (3, 4);


CREATE TABLE comments
(
    id       int(11) NOT NULL,
    content  text not null
);

INSERT INTO comments VALUES
                         (1, 'first_user_first_dwitt_comment'),
                         (2, 'second_user_second_dwitt_comment'),
                         (3, 'first_user_second_dwitt_comment'),
                         (4, 'second_user_third_dwitt_comment');


CREATE TABLE user_comment (
                              user_id int(11) NOT NULL,
                              comment_id int(11) NOT NULL
);

INSERT INTO user_comment VALUES
                             (1, 1),
                             (2, 2),
                             (1, 3),
                             (2, 4);