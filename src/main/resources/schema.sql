CREATE TABLE users
(
    id       serial,
    name     text not null,
    password text not null,

    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE dwitts
(
    id      serial,
    content text not null,
    user_id bigint unsigned,

    CONSTRAINT pk_dwitts PRIMARY KEY (id),
    CONSTRAINT fk_dwitts_users FOREIGN KEY (user_id) REFERENCES users (id)
);

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