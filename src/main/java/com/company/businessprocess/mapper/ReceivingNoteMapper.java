package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = ReceivingNoteDetailMapper.class)
public abstract class ReceivingNoteMapper {
    @Mappings({
            @Mapping(target = "receivingNoteDetailResponses", source = "receivingnotedetailsByReceiveId")
    })
    public abstract ReceivingNoteResponse fromEntityToResponse(ReceivingnoteEntity receivingnoteEntity);

    public abstract ReceivingnoteEntity fromRequestToEntity(ReceivingNoteRequest receivingNoteRequest);

    public abstract ReceivingnoteEntity fromProductEntToReceivingNoteEnt(ProductorderEntity productorderEntity);
}
