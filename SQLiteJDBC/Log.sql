CREATE TABLE Log
(
	id NUMERIC primary key,
	datetime TIMESTAMP default current_timestamp not null,
	mensaje VARCHAR(2000) not null,
	tipo NUMERIC,
	extra VARCHAR(8000)
)

