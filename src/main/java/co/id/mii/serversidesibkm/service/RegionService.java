/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidesibkm.service;

import co.id.mii.serversidesibkm.model.Region;
import co.id.mii.serversidesibkm.repository.RegionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
public class RegionService {
    
    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }
    
    public List<Region> getAll(){
        return regionRepository.findAll();
    }
    
    public Region getById(Long id){
        return regionRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found!"));
    }
    
    public Region create(Region region){
        if (region.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region id is already exists!");
        }
        return regionRepository.save(region);
    }
    
    public Region update(Long id, Region region){
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }
    
    public Region delete(Long id){
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }
}
