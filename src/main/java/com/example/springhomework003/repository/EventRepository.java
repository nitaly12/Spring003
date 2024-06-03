package com.example.springhomework003.repository;

import com.example.springhomework003.model.Event;
import com.example.springhomework003.model.dto.request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface EventRepository {

    @Select("SELECT * FROM events LIMIT #{limit} OFFSET #{offset};")
    @Results(id = "eventMapper", value ={
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",one = @One(select = "com.example.springhomework003.repository.VenueRepository.findVenueById")),
            @Result(property = "attendees", column = "event_id",many = @Many(select = "com.example.springhomework003.repository.AttendeesRepository.findAllAttendeesByEventId"))

    })
    List<Event> findAllEvent(Integer offset, Integer limit);

    @Select("SELECT * FROM events WHERE event_id = #{id}")
    @ResultMap("eventMapper")
    Event findEventById(Integer id);

    @Select("UPDATE events SET event_name = #{event.eventName}, event_date = #{event.eventDate} WHERE event_id = #{id} RETURNING *")
    @ResultMap("eventMapper")
    Event updateEvent(Integer id, @Param("event") EventRequest eventRequest);

    @Select("DELETE FROM events WHERE event_id = #{id} RetURNING *")
    @ResultMap("eventMapper")
    Event deleteEvent(Integer id);

    @Select("INSERT INTO events (event_name,event_date,venue_id) VALUES (#{event.eventName},#{event.eventDate},#{event.venueId}) RETURNING *")
    @ResultMap("eventMapper")
    Event saveEvent(@Param("event") EventRequest eventRequest);

    @Select(("INSERT INTO event_attendees (event_id, attendee_id) VALUES (#{eventId},#{attendeeId})"))
    void saveEventIdAndAttendeesId(Integer eventId, Integer attendeeId);
}
