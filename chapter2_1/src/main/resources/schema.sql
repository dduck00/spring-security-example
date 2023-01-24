CREATE TABLE IF NOT EXISTS `users`
(
    `id`       int          not null primary key auto_increment,
    `username` varchar(128) not null,
    `password` varchar(128) not null,
    `enabled`   int          not null
);

CREATE TABLE IF NOT EXISTS `authorities`
(
    `id`        int          not null primary key auto_increment,
    `username`  varchar(128) not null,
    `authority` varchar(128) not null
);
