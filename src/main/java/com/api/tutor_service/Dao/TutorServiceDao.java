package com.api.tutor_service.Dao;


import com.api.tutor_service.models.tutorService;
import com.api.tutor_service.repositories.tutorReadOnlyRepository;
import com.api.tutor_service.repositories.tutorServiceRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class TutorServiceDao implements tutorReadOnlyRepository, tutorServiceRepository {
    private tutorReadOnlyRepository tutorReadOnlyRepository;
    private tutorServiceRepository tutorServiceRepository;

    public TutorServiceDao(  tutorReadOnlyRepository tutorReadOnlyRepository,   tutorServiceRepository tutorServiceRepository) {
        this.tutorReadOnlyRepository = tutorReadOnlyRepository;
        this.tutorServiceRepository = tutorServiceRepository;
    }

    public List<tutorService> getAllServicesFromMaster() {
        return tutorServiceRepository.findAll();
    }

    public List<tutorService> getAllServicesFromSlave() {
        return tutorReadOnlyRepository.findAll();
    }

    // Methods that come with JpaRepository
    @Override
    public List<tutorService> findAll() {
        return tutorReadOnlyRepository.findAll();
    }

    @Override
    public void delete(tutorService books) {
        tutorServiceRepository.delete(books);
    }

    @Override
    public void deleteAll() {
        tutorServiceRepository.deleteAll();
    }

    @Override
    public <S extends tutorService> S save(S s) {
        return tutorServiceRepository.save(s);
    }

    @Override
    public void flush() {
        tutorServiceRepository.flush();
    }

    @Override
    public <S extends tutorService> S saveAndFlush(S s) {
        return tutorServiceRepository.saveAndFlush(s);
    }

    @Override
    public <S extends tutorService> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public void deleteAllInBatch(Iterable<tutorService> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public tutorService getOne(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public tutorService getById(Long id) {
        // TODO Auto-generated method stub
       throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    
    }

    @Override
    public tutorService getReferenceById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @Override
    public <S extends tutorService> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends tutorService> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends tutorService> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public List<tutorService> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return tutorReadOnlyRepository.findAllById(ids);
    }

    @Override
    public Optional<tutorService> findById(Long id) {
        // TODO Auto-generated method stub
        return tutorReadOnlyRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteAll(Iterable<? extends tutorService> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public List<tutorService> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return tutorReadOnlyRepository.findAll(sort);
    }

    @Override
    public Page<tutorService> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends tutorService> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public <S extends tutorService> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends tutorService> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends tutorService> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends tutorService, R> R findBy(Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }
    
}
