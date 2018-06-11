create table user
(
	id int auto_increment
		primary key,
	username varchar(100) not null,
	password varchar(20) not null,
	name varchar(40) null,
	status enum('active', 'deleted', 'banned') default 'active' null,
	role enum('admin', 'user') default 'user' null,
	constraint user_username_uindex
		unique (username)
)
comment 'users for notes' engine=InnoDB;

create table note
(
	id int auto_increment
		primary key,
	note longtext null,
	board_id int not null,
	createdDate varchar(25) null,
	title varchar(200) null,
	constraint note_board_id_fk
		foreign key (board_id) references board (id)
			on update cascade on delete cascade
)
comment 'notes of users'
;

create index note_board_id_fk
	on note (board_id)
;



INSERT INTO xtrello.user
(id, username, password, name, status, role)
VALUES (1, 'igor@lyutak.com', '1122', 'Igor', 'active', 'admin');

INSERT INTO xtrello.note
(note, board_id, createdDate, title)
VALUES ('test text', 1, '2018-05-19:12:12:12', 'Test');


create table board
(
  id         int auto_increment
    primary key,
  Board      mediumtext null,
  board_id    int        null,
  createDate date       null,
  title      mediumtext null,
  constraint Board_user_id_uindex
  unique (board_id),
  constraint Board_user_id_fk
  foreign key (board_id) references user (id)
    on update cascade
    on delete cascade
);

