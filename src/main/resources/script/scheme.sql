CREATE DATABASE spring_homework;


CREATE TABLE venues
(
    venue_id   SERIAL PRIMARY KEY,
    venue_name VARCHAR(50) NOT NULL,
    location   VARCHAR(255)
);

CREATE TABLE events
(
    event_id   SERIAL PRIMARY KEY,
    event_name VARCHAR(50) NOT NULL,
    event_date DATE NOT NULL,
    venue_id   INTEGER NOT NULL,
    CONSTRAINT event_venue_fk FOREIGN KEY (venue_id) REFERENCES venues(venue_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE attendees
(
    attendee_id    SERIAL PRIMARY KEY,
    attendee_name  VARCHAR(50) NOT NULL,
    email          VARCHAR(255)
);

CREATE TABLE event_attendees
(
    id SERIAL PRIMARY KEY,
    event_id   INTEGER NOT NULL,
    attendee_id INTEGER NOT NULL,
    CONSTRAINT event_fk FOREIGN KEY(event_id) REFERENCES events(event_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT attendee_fk FOREIGN KEY(attendee_id) REFERENCES attendees(attendee_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);