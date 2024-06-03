package com.example.springhomework003.repository;

import com.example.springhomework003.model.Attendees;
import com.example.springhomework003.model.dto.request.AttendeesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AttendeesRepository {

    @Select("SELECT * FROM attendees LIMIT #{limit} OFFSET #{offset};")
    @Results(id = "attendeesMapper", value ={
            @Result(property = "attendeeId" , column = "attendee_id" ),
            @Result(property = "attendeesName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    List<Attendees> findAllAttendees(Integer offset, Integer limit);

    @Select("INSERT INTO attendees (attendee_name,email) VALUES (#{attendees.attendeesName},#{attendees.email}) RETURNING *")
    @ResultMap("attendeesMapper")
    Attendees createAttendees(@Param("attendees") AttendeesRequest attendeesRequest);

    @Select("SELECT * FROM attendees WHERE attendee_id = #{id}")
    @ResultMap("attendeesMapper")
    Attendees findAttendeesById(Integer id);

    @Select("UPDATE attendees SET attendee_name = #{attendees.attendeesName}, email = #{attendees.email} WHERE attendee_id = #{id} RETURNING *")
    @ResultMap("attendeesMapper")
    Attendees updateAttendees(Integer id,@Param("attendees") AttendeesRequest attendeesRequest);

    @Select("DELETE FROM attendees WHERE attendee_id = #{id} RETURNING *")
    @ResultMap("attendeesMapper")
    Attendees deleteAttendees(Integer id);

    @Select("SELECT event_id,a.attendee_name,a.email,a.attendee_id  FROM attendees a INNER JOIN event_attendees ea ON a.attendee_id = ea.attendee_id WHERE event_id = #{eventId}")
    @ResultMap("attendeesMapper")
    List<Attendees> findAllAttendeesByEventId(Integer eventId);
}
