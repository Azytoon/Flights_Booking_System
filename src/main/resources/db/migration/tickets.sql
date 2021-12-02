CREATE TABLE IF NOT EXISTS tickets (
	ticket_id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
	flight_id UUID  NOT NULL DEFAULT uuid_generate_v4(),
	user_id UUID  NOT NULL DEFAULT uuid_generate_v4(),
	ticketClass VARCHAR(6) NOT NULL
        CHECK (
            ticketClass = 'classA'   OR
            ticketClass = 'classB'
        ),
    CONSTRAINT fk_user
      FOREIGN KEY(user_id) 
	  REFERENCES users(user_id)
	  ON DELETE CASCADE,
    CONSTRAINT fk_flight
      FOREIGN KEY(flight_id) 
	  REFERENCES flights(flight_id)
	  ON DELETE CASCADE
);
insert into tickets (flight_id, user_id, ticketClass) values ('a734dc6c-9cbc-4396-abfb-21bd34ac5792','96dd4728-a5c7-494e-a968-835e09e9e9ee','classA');
insert into tickets (flight_id, user_id, ticketClass) values ('dc46ad99-ae1c-429d-b71f-00a2e8e5eb17','96dd4728-a5c7-494e-a968-835e09e9e9ee','classB');
insert into tickets (flight_id, user_id, ticketClass) values ('a734dc6c-9cbc-4396-abfb-21bd34ac5792','ba5a21e7-0484-43a7-a65b-ec61ee7d83b8','classA');
insert into tickets (flight_id, user_id, ticketClass) values ('dc46ad99-ae1c-429d-b71f-00a2e8e5eb17','ba5a21e7-0484-43a7-a65b-ec61ee7d83b8','classA');
insert into tickets (flight_id, user_id, ticketClass) values ('a734dc6c-9cbc-4396-abfb-21bd34ac5792','4f7e9020-dce2-4c74-a0c3-49e6a910357d','classA');
insert into tickets (flight_id, user_id, ticketClass) values ('a734dc6c-9cbc-4396-abfb-21bd34ac5792','c977e250-ab49-4b78-8e11-4fd44aef8ee3','classB');
insert into tickets (flight_id, user_id, ticketClass) values ('dc46ad99-ae1c-429d-b71f-00a2e8e5eb17','4f7e9020-dce2-4c74-a0c3-49e6a910357d','classB');
insert into tickets (flight_id, user_id, ticketClass) values ('dc46ad99-ae1c-429d-b71f-00a2e8e5eb17','c977e250-ab49-4b78-8e11-4fd44aef8ee3','classA');
insert into tickets (flight_id, user_id, ticketClass) values ('153b1e14-5014-4c7f-afc7-be9d29f3b962','96dd4728-a5c7-494e-a968-835e09e9e9ee','classB');
insert into tickets (flight_id, user_id, ticketClass) values ('153b1e14-5014-4c7f-afc7-be9d29f3b962','ba5a21e7-0484-43a7-a65b-ec61ee7d83b8','classA');
