SELECT event_id,a.attendee_name,a.email,a.attendee_id FROM attendees a INNER JOIN
    event_attendees ea ON a.attendee_id = ea.attendee_id WHERE event_id = 23
;

SELECT * FROM events;