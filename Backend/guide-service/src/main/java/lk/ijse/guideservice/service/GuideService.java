package lk.ijse.guideservice.service;

import lk.ijse.guideservice.dto.GuideDTO;

import java.util.ArrayList;
import java.util.List;


public interface GuideService {

    void  addGuide(GuideDTO guideDTO);

    void  deleteGuide(long id);

    void updateGuide(GuideDTO guideDTO);

    ArrayList<GuideDTO> getAllGuides();

    ArrayList<GuideDTO> searchGuideByName(String vehicle_brand);

    GuideDTO findById(long id);
}
