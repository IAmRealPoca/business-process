package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.mapper.ReceivingNoteMapper;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.Optional;

@Service
public class ReceivingNoteServiceImpl implements ReceivingNoteService {

    private ReceivingNoteRepository receivingNoteRepository;
    private StaffRepository staffRepository;
    private ProductRepository productRepository;
    private ReceivingNoteMapper receivingNoteMapper;

    public ReceivingNoteServiceImpl(ReceivingNoteRepository receivingNoteRepository, StaffRepository staffRepository, ProductRepository productRepository, ReceivingNoteMapper receivingNoteMapper) {
        this.receivingNoteRepository = receivingNoteRepository;
        this.staffRepository = staffRepository;
        this.productRepository = productRepository;
        this.receivingNoteMapper = receivingNoteMapper;
    }

    @Override
    public Page<ReceivingNoteResponse> getAllReceivingNote(Pageable pageable) {
        Page<ReceivingnoteEntity> receivingnoteEntities = receivingNoteRepository.findAll(pageable);
        Page<ReceivingNoteResponse> receivingNoteResponses = receivingnoteEntities
                .map(receivingnoteEntity -> receivingNoteMapper.fromEntityToResponse(receivingnoteEntity));
        return receivingNoteResponses;
    }

    @Override
    public Page<ReceivingNoteResponse> searchReceivingNote(Date beginDate, Date endDate, Pageable pageable) {
        Page<ReceivingnoteEntity> receivingnoteEntities;
        if (!ObjectUtils.isEmpty(beginDate)) {
            receivingnoteEntities = receivingNoteRepository.findAllByReceiveDateAfter(beginDate, pageable);
        } else if (!ObjectUtils.isEmpty(endDate)) {
            receivingnoteEntities = receivingNoteRepository.findAllByReceiveDateBefore(endDate, pageable);
        } else {
            receivingnoteEntities = receivingNoteRepository.findAllByReceiveDateBetween(beginDate, endDate, pageable);
        }
        Page<ReceivingNoteResponse> receivingNoteResponses =
                receivingnoteEntities.map(item -> receivingNoteMapper.fromEntityToResponse(item));
        return receivingNoteResponses;
    }

    @Override
    public ReceivingNoteResponse addReceivingNote(ReceivingNoteRequest newReceivingNote) {
        ReceivingnoteEntity newEntity = receivingNoteMapper.fromRequestToEntity(newReceivingNote);
        ProductEntity product = productRepository.getOne(newReceivingNote.getProductId());
        StaffEntity staff = staffRepository.getOne(newReceivingNote.getStaffId());
        newEntity.setStaffByStaffId(staff);
        return receivingNoteMapper.fromEntityToResponse(receivingNoteRepository.save(newEntity));
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
