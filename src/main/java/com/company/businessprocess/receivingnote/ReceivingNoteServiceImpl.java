package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceivingNoteServiceImpl implements ReceivingNoteService {

    private ReceivingNoteRepository receivingNoteRepository;
    private StaffRepository staffRepository;
    private ProductRepository productRepository;
    private ModelMapper mapper;

    public ReceivingNoteServiceImpl(ReceivingNoteRepository receivingNoteRepository, StaffRepository staffRepository, ProductRepository productRepository, ModelMapper mapper) {
        this.receivingNoteRepository = receivingNoteRepository;
        this.staffRepository = staffRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<ReceivingNoteResponse> getAllReceivingNote() {
        Collection<ReceivingNoteResponse> receivingNoteResponses =
                receivingNoteRepository.findAll().stream()
                        .map(receivingnoteEntity -> mapper.map(receivingnoteEntity, ReceivingNoteResponse.class))
                        .collect(Collectors.toList());
        return receivingNoteResponses;
    }

    @Override
    public ReceivingNoteResponse addReceivingNote(ReceivingNoteRequest newReceivingNote) {
        ReceivingnoteEntity newEntity = mapper.map(newReceivingNote, ReceivingnoteEntity.class);
        ProductEntity product = productRepository.getOne(newReceivingNote.getProductId());
        newEntity.setProductByProductId(product);
        StaffEntity staff = staffRepository.getOne(newReceivingNote.getStaffId());
        newEntity.setStaffByStaffId(staff);
        return mapper.map(receivingNoteRepository.save(newEntity), ReceivingNoteResponse.class);

    }

    @Override
    public ReceivingnoteEntity updateReceivingNote(Integer id, ReceivingnoteEntity updateEntity) {
        return receivingNoteRepository.save(updateEntity);
    }

    @Override
    public void deleteReceivingNote(Integer id) {
        Optional<ReceivingnoteEntity> optionalReceivingnoteEntity = receivingNoteRepository.findById(id);
        if (optionalReceivingnoteEntity.isPresent()) {
            receivingNoteRepository.deleteById(id);
        }
    }
}
