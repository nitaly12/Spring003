package com.example.springhomework003.repository;

import com.example.springhomework003.model.Venue;
import com.example.springhomework003.model.dto.request.VenueRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("SELECT * FROM venues LIMIT #{limit} OFFSET #{offset};")
    @Results(id = "venueMapper", value ={
            @Result(property = "venueId" , column = "venue_id" ),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "location", column = "location")
    })
    List<Venue> findAllVenue(Integer offset , Integer limit);

    @Select("INSERT INTO venues (venue_name,location) VALUES (#{venue.venueName} , #{venue.location}) RETURNING *")
    @ResultMap("venueMapper")
    Venue createVenue(@Param("venue") VenueRequest venueRequest);

    @Select("SELECT * FROM venues WHERE venue_id = #{id}")
    @ResultMap("venueMapper")
    Venue findVenueById(Integer id);

    @Select("UPDATE venues SET venue_name = #{venue.venueName}, location = #{venue.location} WHERE venue_id = #{id} RETURNING *")
    @ResultMap("venueMapper")
    Venue updateVenue( Integer id,@Param("venue") VenueRequest venueRequest);

    @Select("DELETE FROM venues WHERE venue_id = #{id} RETURNING *")
    @ResultMap("venueMapper")
    Venue deleteVenue(Integer id);
}
