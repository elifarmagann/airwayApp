package com.armaganelif.airway.controller.mapper;

import com.armaganelif.airway.model.Ticket;
import com.armaganelif.airway.model.dto.TicketResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper MAPPER = Mappers.getMapper(TicketMapper.class);

    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "customer.familyName", target = "customerFamilyName")
    @Mapping(source = "flight.flightNo", target = "flightNo")
    @Mapping(source = "flight.flightDate", target = "flightDate")
    @Mapping(source = "flight.flightTime", target = "flightTime")
    @Mapping(source = "flight.route.departure.name", target = "departure")
    @Mapping(source = "flight.route.destination.name", target = "destination")
    TicketResponseDto toDto(Ticket ticket);
}
