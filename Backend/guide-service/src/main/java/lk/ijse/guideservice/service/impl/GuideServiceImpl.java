package lk.ijse.guideservice.service.impl;

import lk.ijse.guideservice.dto.GuideDTO;
import lk.ijse.guideservice.entity.Guide;
import lk.ijse.guideservice.repo.GuideRepo;
import lk.ijse.guideservice.service.GuideService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuideServiceImpl implements GuideService {

    @Autowired
    GuideRepo guideRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addGuide(GuideDTO guideDTO) {
    if (guideRepo.existsByIdAndContactnumber(guideDTO.getId(),guideDTO.getContactnumber())){
        throw new RuntimeException(guideDTO.getId()+" "+guideDTO.getContactnumber()+"Already exists");
    }
    Guide guide=modelMapper.map(guideDTO,Guide.class);
    guideRepo.save(guide);
    }

    @Override
    public void deleteGuide(long id) {
        if(!guideRepo.existsById(id)){
            throw  new RuntimeException("Guide"+ id +"Not Available!");
        }
        guideRepo.deleteById(id);

    }

    @Override
    public void updateGuide(GuideDTO guideDTO) {

        Optional<Guide> Byid = guideRepo.findById(guideDTO.getId());

        if (Byid.isEmpty()) {

            throw new RuntimeException("ID doesent exists!");
        } else {
            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
        }
    }



    @Override
    public ArrayList<GuideDTO> getAllGuides() {
      return modelMapper.map(guideRepo.findAll(),new TypeToken<ArrayList<GuideDTO>>(){}.getType());
    }

    @Override
    public ArrayList<GuideDTO> searchGuideByName(String guidename) {
       return modelMapper.map(guideRepo.findByGuidename(guidename),new TypeToken<ArrayList<GuideDTO>>(){}.getType());
    }

    @Override
    public GuideDTO findById(long id) {
        return null;
    }
}
